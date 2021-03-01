package com.ebookfrenzy.beaotis.awards

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.activity_awards.*

class Awards : AppCompatActivity() {
    private lateinit var intentToMainActivity:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_awards)

        intentToMainActivity=Intent(this, MainActivity::class.java)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        left_arrow1.setOnClickListener{
            val intent=Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    override fun onBackPressed() {
        startActivity(intentToMainActivity)
        super.onBackPressed()
    }
    override fun onResume() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onResume()
    }

}