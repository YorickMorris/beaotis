package com.ebookfrenzy.beaotis.findingobjects.furnitures

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.FindingObjectsDataClass
import com.ebookfrenzy.beaotis.findingobjects.FindingObjectsMixedRecyclerView
import com.ebookfrenzy.beaotis.findingobjects.IFindingObjectsMixedGenerator
import com.ebookfrenzy.beaotis.findingobjects.IFindingObjectsMixedOnClickListener
import com.ebookfrenzy.beaotis.findingobjects.fruits.FruitsActivity

class GroupMixedFurnitures : AppCompatActivity(), IFindingObjectsMixedOnClickListener,
    IFindingObjectsMixedGenerator {
    private lateinit var intentToFurnituresActivity: Intent
    private lateinit var recyclerView: RecyclerView
    private var mPlayer: MediaPlayer?=null
    val list:MutableList<Int> = getSoundResources(mixed_furnitures())
    var hataListe = mutableListOf<String>()
    var sayac = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_mixed_furnitures)

        mPlayer = MediaPlayer.create(this, list[0])
        mPlayer?.start()
        mPlayer?.setOnCompletionListener {
            Toast.makeText(this,"İlk ses tamamlandı.", Toast.LENGTH_SHORT).show()
            mPlayer?.stop()
            mPlayer?.release()
            mPlayer=null
        }

        intentToFurnituresActivity = Intent(this, FurnituresActivity::class.java)

        recyclerView = findViewById(R.id.furnituresMixedRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        val adapter = FindingObjectsMixedRecyclerView(mixed_furnitures(), this)

        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        //val adapter = SubRecyclerView(fruit_generator(), this)
    }
    override fun onBackPressed() {
        startActivity(intentToFurnituresActivity)
        finish()
        super.onBackPressed()
    }

    override fun onItemClicked(data: FindingObjectsDataClass, position: Int,imageView: ImageView) {
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

        super.onDestroy()
    }
}