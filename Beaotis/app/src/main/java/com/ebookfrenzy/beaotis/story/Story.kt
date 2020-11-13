package com.ebookfrenzy.beaotis.story

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.activity_story.*

class Story : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        val context = this
        left_arrow11.setOnClickListener{
            val intent= Intent(context, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}