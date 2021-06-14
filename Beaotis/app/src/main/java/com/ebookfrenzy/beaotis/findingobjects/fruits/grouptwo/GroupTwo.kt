package com.ebookfrenzy.beaotis.findingobjects.fruits.grouptwo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.fruits.FruitsActivity

class GroupTwo : AppCompatActivity() {
    private lateinit var intentToFruitsActivity: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_two)
        intentToFruitsActivity= Intent(this, FruitsActivity::class.java)
        supportActionBar?.hide()
    }
    override fun onBackPressed() {
        startActivity(intentToFruitsActivity)
        super.onBackPressed()
    }
}