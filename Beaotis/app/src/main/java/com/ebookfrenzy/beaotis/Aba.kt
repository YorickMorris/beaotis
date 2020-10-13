package com.ebookfrenzy.beaotis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_aba.*

class Aba : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aba)

        val context = this
        left_arrow.setOnClickListener{
            val intent=Intent(context,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}