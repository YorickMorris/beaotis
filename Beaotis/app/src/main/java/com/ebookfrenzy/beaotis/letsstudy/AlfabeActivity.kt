package com.ebookfrenzy.beaotis.letsstudy

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.RecyclerViewAdapter
import com.ebookfrenzy.beaotis.findingobjects.FindObjectDataClass
import com.ebookfrenzy.beaotis.findingobjects.FindingObjects

class AlfabeActivity : AppCompatActivity(),IOnLetsStudyClickListener,IAlfabeGenerator {
    private var mPlayer: MediaPlayer? = null
    private lateinit var intentToLetsStudyObjectsActivity: Intent
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alfabe)

        intentToLetsStudyObjectsActivity=Intent(this, LetsStudyActivity::class.java)
        generateList()

        recyclerView = findViewById(R.id.alfabeRecyclerView)
        //GridLayoutManager olacak.
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val adapter = LetsStudyRecyclerView(generateList(), this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onItemClicked(data: LetsStudyExampleItem, position: Int,imageView: ImageView) {
        //Her bir harfe tıklandığında o rakamın telaffuzu sesli şekilde verilecek
        //Ayrıca harflere basıldığında animasyon gerçekleşecek
        mPlayer = MediaPlayer.create(this, data.soundResource)
        mPlayer?.start()
        animation(imageView)
        mPlayer?.setOnCompletionListener {
            mPlayer?.stop()
            mPlayer?.release()
            mPlayer=null

        }
    }
    override fun onBackPressed() {
        startActivity(intentToLetsStudyObjectsActivity)
        finish()
        super.onBackPressed()
    }
    fun animation(imageView: ImageView){
        YoYo.with(Techniques.Pulse )
            .duration(700)
            .repeat(2)
            .playOn(imageView)

    }
}