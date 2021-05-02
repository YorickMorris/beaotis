package com.ebookfrenzy.beaotis.letsstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.*
import kotlinx.android.synthetic.main.activity_lets_study.*

class LetsStudyActivity : AppCompatActivity(),ILetsStudyRecyclerViewGenerator,
    IOnItemClickListener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var intentToMainActivity:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lets_study)
        intentToMainActivity=Intent(this,MainActivity::class.java)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        recyclerView = findViewById(R.id.recyclerViewLetsStudy)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val adapter=RecyclerViewAdapter(generateLetsStudy(),this)
        recyclerView.adapter=adapter
        adapter.notifyDataSetChanged()

        left_arrow6.setOnClickListener{
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

    override fun onItemClicked(data: ExampleItem, position: Int, coloumn: Int) {
        when(position){
            0->
                when(coloumn){
                    1->intent = Intent(this, AlfabeActivity::class.java)
                    2->intent = Intent(this, NumbersActivity::class.java)
                    3->intent = Intent(this, SeasonsActivity::class.java)
                }
            1->
                when(coloumn){
                    1->intent = Intent(this, MathematicActivity::class.java)
                    2->intent = Intent(this, ColorsActivity::class.java)
                    3->intent = Intent(this, PracticesActivity::class.java)
                }
        }
        startActivity(intent)
        finish()
    }
}