package com.ebookfrenzy.beaotis.findingobjects.fruits.groupone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.FindingObjects
import com.ebookfrenzy.beaotis.findingobjects.fruits.FruitsActivity

class GroupOne : AppCompatActivity() {
    private lateinit var intentToFruitsActivity: Intent

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_one)
        intentToFruitsActivity= Intent(this, FruitsActivity::class.java)
        supportActionBar?.hide()
    }
    override fun onBackPressed() {
        startActivity(intentToFruitsActivity)

        /*val fragmet=this.supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
        (fragmet as? IOnBackPressedListener)?.onBackPressed()?.not()?.let {
            super.onBackPressed()
        }*/
        super.onBackPressed()
    }

}