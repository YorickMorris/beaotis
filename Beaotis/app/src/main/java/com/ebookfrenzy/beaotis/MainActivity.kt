package com.ebookfrenzy.beaotis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.aba.Aba
import com.ebookfrenzy.beaotis.awards.Awards
import com.ebookfrenzy.beaotis.completesentence.CompleteSentence
import com.ebookfrenzy.beaotis.educationalsongs.EducationalSongs
import com.ebookfrenzy.beaotis.etiquette.Etiquette
import com.ebookfrenzy.beaotis.findingobjects.FindingObjects
import com.ebookfrenzy.beaotis.letsstudy.LetsStudyActivity
import com.ebookfrenzy.beaotis.letstalk.LetsTalk
import com.ebookfrenzy.beaotis.makeittogether.MakeItTogether
import com.ebookfrenzy.beaotis.markyourheard.MarkYourHeard
import com.ebookfrenzy.beaotis.pairing.Pairing
import com.ebookfrenzy.beaotis.parent.ParentActivity
import com.ebookfrenzy.beaotis.story.Story
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() , IGeneratorInterface, IOnItemClickListener,IFireStoreList,SignInDialogFragment.IGirisYap {
    private lateinit var recyclerView: RecyclerView
    private val dialogFragment=SignInDialogFragment()
    private lateinit var auth: FirebaseAuth
    private val tag:String="MainActiviy"
    private val db = Firebase.firestore
    private var user:FirebaseUser?=null
    //private val docRef = db.collection("uploads").document("1").get()
    //private val list:MutableList<>
    //private val timestamp: FieldValue = FieldValue.serverTimestamp()
    private val c:Date=Calendar.getInstance().time
    private val df:SimpleDateFormat= SimpleDateFormat("dd-MMM-yyyy",Locale.CANADA)
    private val formatDate=df.format(c)
    private var dogruSayac=0
    private var yanlisSayac=0
    private val a="groupMixFruits"

    override fun onCreate(savedInstanceState: Bundle?) {
       /* readData(object : MyCallback() {
            fun onCallback(settings: UserAccountSettings) {
                Log.d("TAG", settings.getDisplay_name())
            }
        })*/
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateList()




       /* db.collection("x").add(mapOf(
            "created" to timestamp
        )).addOnSuccessListener {

            val id=it.id
        }*/


        //Log.d("Kullanıcı", "Kullanıcı: ${timestamp.toString()}")
        Log.d("Formatted Date", "Formatlanmış Tarih: $formatDate")
        //window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        auth = Firebase.auth
        //val currentTime:String=getCurrentTime()
        val a=getGroupOne(db)
        println("Birinci grup= $a")
        /*if(currentTime=="9:40 ÖÖ"){
            createNotification(this)
            createNotificationChannel()
        }*/


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter = RecyclerViewAdapter(generateList(), this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        toolbar.setNavigationOnClickListener {
            if (FirebaseAuth.getInstance().currentUser!=null){
                intent = Intent(this, ParentActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                if(savedInstanceState==null){
                    dialogFragment.run { show(supportFragmentManager, "missiles") }
                }
            }




            Log.d(tag, "Tıklandı.")
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Bu kod ebeveyn modülüne geçmeyi sağlıyor.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_switch -> {
                intent = Intent(this, LetsStudyActivity::class.java)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
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

    override fun onCallBack(liste: MutableList<String>?){

    }

    /*private fun createNotificationChannel() {
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
    }*/
    /* private fun createNotification(context: Context) {
        val notificationId=0
        //Bu kod ile bildirime tıklayarak uygulama açılabilir.
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        val builder = NotificationCompat.Builder(context, R.string.x.toString())
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
    }*/
    /* private fun getCurrentTime():String{
        val currentTime:String?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("h:mm a")
            currentTime = current.format(formatter)
            return currentTime
        } else {
            val c: Calendar = Calendar.getInstance()
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
    }*/
    override fun onResume() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onResume()
    }
    override fun onStart() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onStart()
    }

    override fun girisYap(user: FirebaseUser?):FirebaseUser? {
        Log.d("Kullanıcı", "Kullanıcı: $user")
        if (user!=null){
            intent = Intent(this, ParentActivity::class.java)
            startActivity(intent)
            finish()
        }
        return user
    }



}
