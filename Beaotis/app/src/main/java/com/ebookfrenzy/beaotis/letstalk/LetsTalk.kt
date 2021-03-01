package com.ebookfrenzy.beaotis.letstalk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.activity_lets_talk.*

class LetsTalk : AppCompatActivity() {
    private lateinit var intentToMainActivity:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lets_talk)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        intentToMainActivity=Intent(this, MainActivity::class.java)
        left_arrow7.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onResume() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onResume()
    }
    override fun onBackPressed() {
        startActivity(intentToMainActivity)
        super.onBackPressed()
    }
}