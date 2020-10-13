package com.ebookfrenzy.beaotis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_etiquette.*

class Etiquette : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etiquette)

        val context = this
        left_arrow4.setOnClickListener{
            val intent= Intent(context,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}