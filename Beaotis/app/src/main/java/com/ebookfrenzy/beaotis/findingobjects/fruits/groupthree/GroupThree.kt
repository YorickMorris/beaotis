package com.ebookfrenzy.beaotis.findingobjects.fruits.groupthree

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.R

class GroupThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_three)

        supportActionBar?.hide()
    }
}