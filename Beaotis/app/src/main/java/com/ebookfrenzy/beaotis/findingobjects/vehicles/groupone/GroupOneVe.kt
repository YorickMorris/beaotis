package com.ebookfrenzy.beaotis.findingobjects.vehicles.groupone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.vegetables.VegetablesActivity
import com.ebookfrenzy.beaotis.findingobjects.vehicles.VehiclesActivity

class GroupOneVe : AppCompatActivity() {
    private lateinit var intentToVehiclesActivity: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_one_ve)
        intentToVehiclesActivity= Intent(this, VehiclesActivity::class.java)
        supportActionBar?.hide()
    }
    override fun onBackPressed() {
        startActivity(intentToVehiclesActivity)
        super.onBackPressed()
    }
}