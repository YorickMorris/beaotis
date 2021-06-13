package com.ebookfrenzy.beaotis.findingobjects.vegetables

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
import com.ebookfrenzy.beaotis.findingobjects.fruits.groupone.GroupOne
import com.ebookfrenzy.beaotis.findingobjects.fruits.groupthree.GroupThree
import com.ebookfrenzy.beaotis.findingobjects.fruits.grouptwo.GroupTwo
import com.ebookfrenzy.beaotis.findingobjects.vegetables.groupone.GroupOneV
import com.ebookfrenzy.beaotis.findingobjects.vegetables.groupthree.GroupThreeV
import com.ebookfrenzy.beaotis.findingobjects.vegetables.grouptwo.GroupTwoV

class VegetablesActivity : AppCompatActivity() , IVegetablesGenerator, SubObjectsClickListener {
    private lateinit var intentToMainActivity: Intent
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vegetables)

        recyclerView = findViewById(R.id.vegetablesRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        val adapter = SubRecyclerView(vegetables_generator(), this)

        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onItemClicked(data: SubObjectDataClass, position: Int) {
        when(position)
        {
            0->intent = Intent(this, GroupOneV::class.java)
            1->intent = Intent(this, GroupTwoV::class.java)
            2->intent = Intent(this, GroupThreeV::class.java)
        }
        startActivity(intent)

    }
}