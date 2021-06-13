package com.ebookfrenzy.beaotis.findingobjects.vegetables.groupone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.R

class GroupOneV : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_one_v)

        supportActionBar?.hide()
    }
}