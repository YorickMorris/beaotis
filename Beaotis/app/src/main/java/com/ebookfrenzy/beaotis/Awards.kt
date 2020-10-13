package com.ebookfrenzy.beaotis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_awards.*

class Awards : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_awards)

        val context = this
        left_arrow1.setOnClickListener{
            val intent=Intent(context,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}