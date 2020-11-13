package com.ebookfrenzy.beaotis.markyourheard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.activity_mark_your_heard.*

class MarkYourHeard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mark_your_heard)

        val context = this
        left_arrow9.setOnClickListener{
            val intent= Intent(context, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}