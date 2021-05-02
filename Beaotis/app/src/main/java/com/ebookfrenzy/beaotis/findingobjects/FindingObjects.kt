package com.ebookfrenzy.beaotis.findingobjects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.letsstudy.LetsStudyActivity
import kotlinx.android.synthetic.main.activity_finding_objects.*

class FindingObjects : AppCompatActivity(),IOnFindingObjectsClickListener,IFindingObjectGenerator {
    private lateinit var intentToMainActivity:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finding_objects)
        intentToMainActivity=Intent(this, MainActivity::class.java)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        left_arrow5.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
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

    override fun onItemClicked(data: FindObjectDataClass, position: Int) {
        when(position){
            0->intent = Intent(this, FruitsActivity::class.java)
            1->intent = Intent(this, VegetablesActivity::class.java)
            2->intent = Intent(this, VehiclesActivity::class.java)
            3->intent = Intent(this, FurnituresActivity::class.java)
        }
        startActivity(intent)
        finish()
    }

}