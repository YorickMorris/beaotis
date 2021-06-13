package com.ebookfrenzy.beaotis.findingobjects.fruits

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.SubObjectDataClass
import com.ebookfrenzy.beaotis.findingobjects.SubObjectsClickListener
import com.ebookfrenzy.beaotis.findingobjects.SubRecyclerView
import com.ebookfrenzy.beaotis.findingobjects.fruits.groupone.GroupOne
import com.ebookfrenzy.beaotis.findingobjects.fruits.groupthree.GroupThree
import com.ebookfrenzy.beaotis.findingobjects.fruits.grouptwo.GroupTwo

class FruitsActivity : AppCompatActivity(),IFruitsGenerator,SubObjectsClickListener {
    private lateinit var intentToMainActivity: Intent
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fruits)

        recyclerView = findViewById(R.id.fruitsRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        val adapter =SubRecyclerView(fruit_generator(), this)

        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onItemClicked(data: SubObjectDataClass, position: Int) {
        when(position)
        {
            0->intent = Intent(this, GroupOne::class.java)
            1->intent = Intent(this, GroupTwo::class.java)
            2->intent = Intent(this, GroupThree::class.java)
        }
        startActivity(intent)
    }
}