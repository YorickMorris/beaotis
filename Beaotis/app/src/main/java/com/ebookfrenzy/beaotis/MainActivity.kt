package com.ebookfrenzy.beaotis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.deneme.*

class MainActivity : AppCompatActivity() , GeneratorInterface, OnItemClickListener{
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateList()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val adapter=RecyclerViewAdapter(generateList(),this)
        recyclerView.adapter=adapter
        adapter.notifyDataSetChanged()
        }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onItemClicked(data: ExampleItem, position: Int, coloumn: Int) {
        Log.d("clickeditem", "$data --- $position")
        when(position){
          0 -> {
              when(coloumn){
                  1 -> intent=Intent(this,LetsStudyActivity::class.java)
                  2 -> intent= Intent(this,MarkYourHeard::class.java)
                  3 -> intent= Intent(this,Pairing::class.java)
              }
          }
          1->{
              when(coloumn){
                  1-> intent= Intent(this,EducationalSongs::class.java)
                  2-> intent= Intent(this,Etiquette::class.java)
                  3-> intent= Intent(this,Story::class.java)
              }

          }
          2->{
              when(coloumn){
                  1-> intent= Intent(this,CompleteSentence::class.java)
                  2-> intent= Intent(this,MakeItTogether::class.java)
                  3-> intent= Intent(this,FindingObjects::class.java)

              }
          }
          3->{
              when(coloumn){
                  1-> intent= Intent(this,LetsTalk::class.java)
                  2-> intent= Intent(this,Awards::class.java)
                  3-> intent= Intent(this,Aba::class.java)
              }
          }

        }
        startActivity(intent)
        finish()
    }


}

