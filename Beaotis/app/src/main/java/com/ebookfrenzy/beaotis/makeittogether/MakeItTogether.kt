package com.ebookfrenzy.beaotis.makeittogether

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.activity_make_it_together.*

class MakeItTogether : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_it_together)

        val context = this

        left_arrow8.setOnClickListener{
            val intent= Intent(context, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}