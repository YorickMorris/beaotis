package com.ebookfrenzy.beaotis.findingobjects

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.RecyclerViewAdapter
import com.ebookfrenzy.beaotis.findingobjects.fruits.FruitsActivity
import com.ebookfrenzy.beaotis.findingobjects.furnitures.FurnituresActivity
import com.ebookfrenzy.beaotis.findingobjects.vegetables.VegetablesActivity
import com.ebookfrenzy.beaotis.findingobjects.vehicles.VehiclesActivity
import kotlinx.android.synthetic.main.activity_finding_objects.*

class FindingObjects : AppCompatActivity(),IOnFindingObjectsClickListener,IFindingObjectGenerator {
    private lateinit var intentToMainActivity:Intent
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finding_objects)
        intentToMainActivity=Intent(this, MainActivity::class.java)

        recyclerView = findViewById(R.id.recyclerView1)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        val adapter = ObjectMainRecyclerView(find_generateList(), this)

        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()


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