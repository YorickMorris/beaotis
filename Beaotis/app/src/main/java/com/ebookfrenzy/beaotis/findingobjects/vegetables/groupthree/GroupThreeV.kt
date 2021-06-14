package com.ebookfrenzy.beaotis.findingobjects.vegetables.groupthree

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.vegetables.VegetablesActivity

class GroupThreeV : AppCompatActivity() {
    private lateinit var intentToVegetablesActivity: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_three_v)
        intentToVegetablesActivity= Intent(this, VegetablesActivity::class.java)
        supportActionBar?.hide()
    }
    override fun onBackPressed() {
        startActivity(intentToVegetablesActivity)
        super.onBackPressed()
    }
}