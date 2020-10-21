package com.ebookfrenzy.beaotis

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.VISIBILITY_PRIVATE
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() , GeneratorInterface, OnItemClickListener {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var currentTime:String=getCurrentTime()
        generateList()
        if(currentTime=="9:40 ÖÖ"){
            createNotification(this)
            createNotificationChannel()
        }

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = RecyclerViewAdapter(generateList(), this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onItemClicked(data: ExampleItem, position: Int, coloumn: Int) {
        Log.d("clickeditem", "$data --- $position")
        when (position) {
            0 -> {
                when (coloumn) {
                    1 -> intent = Intent(this, LetsStudyActivity::class.java)
                    2 -> intent = Intent(this, MarkYourHeard::class.java)
                    3 -> intent = Intent(this, Pairing::class.java)
                }
            }
            1 -> {
                when (coloumn) {
                    1 -> intent = Intent(this, EducationalSongs::class.java)
                    2 -> intent = Intent(this, Etiquette::class.java)
                    3 -> intent = Intent(this, Story::class.java)
                }
            }
            2 -> {
                when (coloumn) {
                    1 -> intent = Intent(this, CompleteSentence::class.java)
                    2 -> intent = Intent(this, MakeItTogether::class.java)
                    3 -> intent = Intent(this, FindingObjects::class.java)
                }
            }
            3 -> {
                when (coloumn) {
                    1 -> intent = Intent(this, LetsTalk::class.java)
                    2 -> intent = Intent(this, Awards::class.java)
                    3 -> intent = Intent(this, Aba::class.java)
                }
            }
        }
        startActivity(intent)
        finish()
    }
    private fun createNotificationChannel() {
        // Bildirim kanalı oluşturulur fakat API 26 ve üzeriyse bildirim kanalı oluşturulur.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.x)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(R.string.x.toString(), name, importance).apply {
                description = descriptionText
            }
            // Sistemle kanala kayıt olma
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
    private fun createNotification(context: Context) {
        val notificationId=0
        //Bu kod ile bildirime tıklayarak uygulama açılabilir.
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        var builder = NotificationCompat.Builder(context, R.string.x.toString())
            .setSmallIcon(R.drawable.ic_baseline_view_headline_24)
            .setContentTitle("Su İçin")
            .setContentText("Vücut sağlığınızı korumak için su için. ")
            //Büyültülebilir bildirim için.
            //.setStyle(NotificationCompat.BigTextStyle()
            //    .bigText("Much longer text that cannot fit one line..."))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setCategory(NotificationCompat.CATEGORY_REMINDER)
            .setVisibility(VISIBILITY_PRIVATE)
            .setTimeoutAfter(300000)
            .setShortcutId("bÖÖ")
            .setContentIntent(pendingIntent)//bu sayede kullanıcının uygulamaya girmesini tetikliyoruz.
            .setAutoCancel(true)//Bu ise bildirim basıldığında bildirimin silinmesini sağlıyor.
        with(NotificationManagerCompat.from(this)) {
            // notificationId is a unique int for each notification that you must define
            notify(notificationId, builder.build())
        }
    }
    private fun getCurrentTime():String{
        var currentTime:String?=null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("h:mm a")
            currentTime = current.format(formatter)
            return currentTime
        } else {
            var c: Calendar = Calendar.getInstance()
            val sHour:String=c.get(Calendar.HOUR_OF_DAY).toString()
            val sMinute:String=c.get(Calendar.MINUTE).toString()
            var sAMorPM:String=c.get(Calendar.AM_PM).toString()
            if(sAMorPM=="0")
                sAMorPM="ÖÖ"
            else
                sAMorPM=="ÖS"
            currentTime="$sHour:$sMinute $sAMorPM"
            println("Şu anki zaman: $currentTime")
            return currentTime
        }
    }
}
