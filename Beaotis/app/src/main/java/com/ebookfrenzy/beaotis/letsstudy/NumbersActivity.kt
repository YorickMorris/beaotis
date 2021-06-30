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
import com.ebookfrenzy.beaotis.findingobjects.FindObjectDataClass

class NumbersActivity : AppCompatActivity() ,IOnLetsStudyClickListener ,INumbersGenerator{
    private var mPlayer: MediaPlayer? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var intentToLetsStudyObjectsActivity: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_numbers)
        intentToLetsStudyObjectsActivity=Intent(this, LetsStudyActivity::class.java)
        generateList()
        recyclerView = findViewById(R.id.numbersRecyclerView)
        //GridLayoutManager olacak.
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val adapter = LetsStudyRecyclerView(generateList(), this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onItemClicked(data: LetsStudyExampleItem, position: Int,imageView: ImageView) {
        //Her bir rakama tıklandığında o rakamın telaffuzu sesli şekilde verilecek
        //Ayrıca rakamlara basıldığında animasyon gerçekleşecek
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