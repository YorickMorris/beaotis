package com.ebookfrenzy.beaotis.findingobjects.furnitures

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.SubObjectDataClass
import com.ebookfrenzy.beaotis.findingobjects.SubObjectsClickListener
import com.ebookfrenzy.beaotis.findingobjects.SubRecyclerView
import com.ebookfrenzy.beaotis.findingobjects.fruits.IFruitsGenerator

class FurnituresActivity : AppCompatActivity() , IFurnituresGenerator, SubObjectsClickListener {
    private lateinit var intentToMainActivity: Intent
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_furnitures)

        recyclerView = findViewById(R.id.furnituresRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        val adapter = SubRecyclerView(furnitures_generator(), this)

        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }

    override fun onItemClicked(data: SubObjectDataClass, position: Int) {

    }
}