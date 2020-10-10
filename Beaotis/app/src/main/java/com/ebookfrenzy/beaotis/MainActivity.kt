package com.ebookfrenzy.beaotis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        generateList()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val adapter=RecyclerViewAdapter(generateList())
        recyclerView.adapter=adapter
        adapter.notifyDataSetChanged()
        }
    private fun generateList(): List<ExampleItem>{
        val list=ArrayList<ExampleItem>()
            list.add(ExampleItem(R.drawable.teach,text1 = "Öğrenelim",
                R.drawable.sound,text2 = "Duyduğunu İşaretle",
                R.drawable.cardgame,text3 = "Eşleştirme"))
            list.add(ExampleItem(R.drawable.listening,text1 = "Eğitici Şarkılar",
                R.drawable.parchment,text2 = "Görgü Kuralları",
                R.drawable.storytelling,text3 = "Bir Hikayem Var"))
            list.add(ExampleItem(R.drawable.clipboard,text1 = "Kelimeyi Tamamla",
                R.drawable.family,text2 = "Birlikte Yapalım",
                R.drawable.binoculars,text3 = "Nesneleri Bul"))
            list.add(ExampleItem(R.drawable.chat,text1 = "Hadi Konuşalım",
               R.drawable.trophy,text2 = "Ödüllerim",
               R.drawable.ic_launcher_foreground,text3 = "ABA"))


        return list
    }
}
