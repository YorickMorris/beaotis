package com.ebookfrenzy.beaotis.findingobjects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.activity_finding_objects.*

class FindingObjects : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finding_objects)

        val context = this
        left_arrow5.setOnClickListener{
            val intent= Intent(context, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}