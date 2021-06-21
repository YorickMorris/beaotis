package com.ebookfrenzy.beaotis.findingobjects.fruits

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.*

class GroupMixed : AppCompatActivity(),IFindingObjectsMixedOnClickListener,IFindingObjectsMixedGenerator {
    private lateinit var intentToFruitsActivity: Intent
    private lateinit var recyclerView: RecyclerView
    private var mPlayer: MediaPlayer? = null
    val list:MutableList<Int> = getSoundResources(mixed_generateList())
    var hataListe = mutableListOf<String>()
    var sayac = 0
    private var mediaPlayer:MediaPlayer?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_mixed)


        mPlayer = MediaPlayer.create(this, list[0])
        mPlayer?.start()
        mPlayer?.setOnCompletionListener {
            mPlayer?.stop()
            mPlayer?.release()
        }

        intentToFruitsActivity = Intent(this, FruitsActivity::class.java)

        recyclerView = findViewById(R.id.fruitsMixedRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        val adapter = FindingObjectsMixedRecyclerView(mixed_generateList(), this)

        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        //val adapter = SubRecyclerView(fruit_generator(), this)

    }


    override fun onBackPressed() {
        startActivity(intentToFruitsActivity)
        finish()
        super.onBackPressed()
    }

    override fun onItemClicked(data: FindingObjectsDataClass, position: Int) {

    /*    if (sayac == 0) {
            Log.d("x","LİSTE KARILDI!")
            Log.d("Liste karılmadan önce: ","$list")
            list.shuffle()
            Log.d("Liste karıldıktan sonra","$list")
            sayac++
        }*/

        //Eğer basması istendiği nesneye basmışsa doğru dedirt.
        //Yanlışsa bir şey yapma.
        //Ardından bir sonraki meyveyi seçmesi istensin.
        Log.d("Data.Onclick SES","$list")
        if (data.soundResource == list[position]) {
            Log.d("x","SES DOSYALARI EŞLEŞTİ!")
            mediaPlayer = MediaPlayer.create(this, R.raw.balontelaffuz)//Tebrikler
            mediaPlayer?.setOnCompletionListener {
                mediaPlayer?.stop()
            }
                if (position + 1 < 9) {
                    mediaPlayer = MediaPlayer.create(
                        this,
                        list[position + 1]
                    )//Bir sonraki tıklanılması istenen şey
                    Log.d("x","BİR SONRAKİ SES OYNATILSIN!")
                    mediaPlayer?.setOnCompletionListener {
                        mediaPlayer?.stop()
                    }
                }
            
        } else
            hataListe.add("${position} yanlış girildi.")

    }

    override fun onStop() {
        mPlayer?.release()
        super.onStop()
    }
}