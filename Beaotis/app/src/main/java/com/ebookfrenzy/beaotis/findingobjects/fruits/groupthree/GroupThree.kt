package com.ebookfrenzy.beaotis.findingobjects.fruits.groupthree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.fruits.FruitsActivity

class GroupThree : AppCompatActivity() {
    private lateinit var intentToFruitsActivity: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_three)
        intentToFruitsActivity= Intent(this, FruitsActivity::class.java)
        supportActionBar?.hide()
    }
    override fun onBackPressed() {
        startActivity(intentToFruitsActivity)
        super.onBackPressed()
    }
}