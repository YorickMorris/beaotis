package com.ebookfrenzy.beaotis.findingobjects.fruits

import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.*

class GroupMixed : AppCompatActivity(),IFindingObjectsMixedOnClickListener,IFindingObjectsMixedGenerator {
    private lateinit var intentToFruitsActivity: Intent
    private lateinit var recyclerView: RecyclerView
    private var mPlayer: MediaPlayer?=null
    val list:MutableList<Int> = getSoundResources(mixed_generateList())
    var hataListe = mutableListOf<String>()
    var sayac = 0
    private var soundPool:SoundPool?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_mixed)

        val audioAttributes:AudioAttributes=AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
            .setContentType(AudioAttributes.CONTENT_TYPE_UNKNOWN)
            .build()
        soundPool=SoundPool.Builder()
            .setMaxStreams(9)
            .setAudioAttributes(audioAttributes)
            .build()


        mPlayer = MediaPlayer.create(this, list[0])
        mPlayer?.start()
        mPlayer?.setOnCompletionListener {
            Toast.makeText(this,"İlk ses tamamlandı.",Toast.LENGTH_SHORT).show()
            mPlayer?.stop()
            mPlayer?.release()
            mPlayer=null
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
        if(sayac==8 && data.soundResource==list[sayac]){
            mPlayer = MediaPlayer.create(this, R.raw.tebrikler)
            mPlayer?.start()
            mPlayer?.setOnCompletionListener {
                mPlayer?.stop()
                mPlayer?.release()
                mPlayer=null
            }
        }
        if(sayac!=8){
            if (data.soundResource == list[sayac]) {
                mPlayer = MediaPlayer.create(this, R.raw.tebrikler)
                mPlayer?.start()
                mPlayer?.setOnCompletionListener {
                    mPlayer?.stop()
                    mPlayer?.release()
                    mPlayer=null

                    mPlayer = MediaPlayer.create(this, list[sayac+1])
                    mPlayer?.start()
                    mPlayer?.setOnCompletionListener {
                        mPlayer?.stop()
                        mPlayer?.release()
                        mPlayer=null

                    }
                    sayac++
                }

            } else
                hataListe.add("${position} yanlış girildi.")
        }


    }

    override fun onStop() {
        mPlayer?.release()
        super.onStop()
    }

    override fun onDestroy() {
        soundPool?.release()
        soundPool=null
        super.onDestroy()
    }
}