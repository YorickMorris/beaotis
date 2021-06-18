package com.ebookfrenzy.beaotis.letsstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.R

class MathematicActivity : AppCompatActivity() {
    private lateinit var intentToLetsStudyObjectsActivity: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mathematic)

        intentToLetsStudyObjectsActivity=Intent(this, LetsStudyActivity::class.java)
    }
    override fun onBackPressed() {
        startActivity(intentToLetsStudyObjectsActivity)
        finish()
        super.onBackPressed()
    }
}