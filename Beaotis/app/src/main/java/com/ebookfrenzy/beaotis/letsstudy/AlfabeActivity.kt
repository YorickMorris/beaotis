package com.ebookfrenzy.beaotis.letsstudy

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.RecyclerViewAdapter
import com.ebookfrenzy.beaotis.findingobjects.FindObjectDataClass

class AlfabeActivity : AppCompatActivity(),IOnLetsStudyClickListener,IAlfabeGenerator {
    private var mPlayer: MediaPlayer? = null
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alfabe)

        generateList()
        recyclerView = findViewById(R.id.alfabeRecyclerView)
        //GridLayoutManager olacak.
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val adapter = LetsStudyRecyclerView(generateList(), this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onItemClicked(data: LetsStudyExampleItem, position: Int) {
        //Her bir iteme tıklandığında ses çıkartma işlemi burada olacak.
        when(position){
            0-> {
                mPlayer=MediaPlayer.create(this, R.raw.armuttelaffuz)
                mPlayer?.start()
            }

            /*1->
            2->
            3->
            4->
            5->
            6->
            7->
            8->
            9->
            10->
            11->
            12->
            13->
            14->
            15->
            16->
            17->
            18->
            19->
            20->
            21->
            22->
            23->
            24->
            25->
            26->
            27->
            28->*/
        }
    }
}