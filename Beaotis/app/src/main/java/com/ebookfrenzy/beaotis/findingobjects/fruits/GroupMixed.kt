package com.ebookfrenzy.beaotis.findingobjects.fruits

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.FindingObjects
import com.ebookfrenzy.beaotis.findingobjects.SubRecyclerView

class GroupMixed : AppCompatActivity() {
    private lateinit var intentToFruitsActivity: Intent
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_mixed)

        intentToFruitsActivity=Intent(this, FruitsActivity::class.java)

        recyclerView = findViewById(R.id.fruitsMixedRecyclerView)

        recyclerView.layoutManager = GridLayoutManager(this, 3)
        //val adapter = SubRecyclerView(fruit_generator(), this)

    }


    override fun onBackPressed() {
        startActivity(intentToFruitsActivity)
        super.onBackPressed()
    }
}