package com.ebookfrenzy.beaotis.completesentence

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.activity_complete_sentence.*

class CompleteSentence : AppCompatActivity() {
    private lateinit var intentToMainActivity:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complete_sentence)

        intentToMainActivity=Intent(this, MainActivity::class.java)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        left_arrow2.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun startCompleteSentence(view: View){view.visibility=View.GONE}

    override fun onResume() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onResume()
    }

    override fun onBackPressed() {
        startActivity(intentToMainActivity)
        super.onBackPressed()
    }


}