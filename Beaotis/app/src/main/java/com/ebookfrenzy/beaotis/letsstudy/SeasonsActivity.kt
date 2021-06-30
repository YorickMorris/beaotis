package com.ebookfrenzy.beaotis.letsstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.FindObjectDataClass

class SeasonsActivity : AppCompatActivity() ,IOnLetsStudyClickListener,ISeasonsGenerator{
    private lateinit var recyclerView: RecyclerView
    private lateinit var intentToLetsStudyObjectsActivity: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seasons)
        intentToLetsStudyObjectsActivity= Intent(this, LetsStudyActivity::class.java)
    }

    override fun onItemClicked(data: LetsStudyExampleItem, position: Int,imageView: ImageView) {
        TODO("Not yet implemented")
    }
    override fun onBackPressed() {
        startActivity(intentToLetsStudyObjectsActivity)
        finish()
        super.onBackPressed()
    }
}