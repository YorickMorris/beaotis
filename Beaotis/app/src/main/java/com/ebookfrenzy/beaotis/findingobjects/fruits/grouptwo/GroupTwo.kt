package com.ebookfrenzy.beaotis.findingobjects.fruits.grouptwo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.R

class GroupTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_two)

        supportActionBar?.hide()
    }
}