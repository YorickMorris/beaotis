package com.ebookfrenzy.beaotis.findingobjects.furnitures.groupone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.fruits.FruitsActivity
import com.ebookfrenzy.beaotis.findingobjects.furnitures.FurnituresActivity

class GroupOneF : AppCompatActivity() {
    private lateinit var intentToFurnituresActivity: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_one_f)
        intentToFurnituresActivity= Intent(this, FurnituresActivity::class.java)
        supportActionBar?.hide()
    }
    override fun onBackPressed() {
        startActivity(intentToFurnituresActivity)
        super.onBackPressed()
    }
}