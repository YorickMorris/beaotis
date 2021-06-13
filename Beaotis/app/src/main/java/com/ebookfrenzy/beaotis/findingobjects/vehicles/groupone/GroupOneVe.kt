package com.ebookfrenzy.beaotis.findingobjects.vehicles.groupone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.R

class GroupOneVe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_one_ve)

        supportActionBar?.hide()
    }
}