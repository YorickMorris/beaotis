package com.ebookfrenzy.beaotis.letsstudy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.FindObjectDataClass

class ColorsActivity : AppCompatActivity() ,IOnLetsStudyClickListener,IColorsGenerator{
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_colors)
    }

    override fun onItemClicked(data: LetsStudyExampleItem, position: Int) {
        TODO("Not yet implemented")
    }
}