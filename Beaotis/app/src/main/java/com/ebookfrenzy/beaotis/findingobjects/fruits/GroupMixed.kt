package com.ebookfrenzy.beaotis.findingobjects.fruits

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.*

class GroupMixed : AppCompatActivity(),IFindingObjectsMixedOnClickListener,IFindingObjectsMixedGenerator {
    private lateinit var intentToFruitsActivity: Intent
    private lateinit var recyclerView: RecyclerView
    private var mPlayer: MediaPlayer? = null
    val list=mixed_generateList()
    var hataListe = mutableListOf<String>()
    var sayac=0
    //karışık ve mixed_geneRateList tipinde bir liste oluştur ona göre onclick methodunda çağır.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_mixed)




        mPlayer= MediaPlayer.create(this, list[0].soundResource)
        mPlayer?.start()
        mPlayer?.setOnCompletionListener {
            mPlayer?.release()
        }

        intentToFruitsActivity=Intent(this, FruitsActivity::class.java)

        recyclerView = findViewById(R.id.fruitsMixedRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        val adapter = FindingObjectsMixedRecyclerView(mixed_generateList(), this)

        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        //val adapter = SubRecyclerView(fruit_generator(), this)

    }


    override fun onBackPressed() {
        startActivity(intentToFruitsActivity)
        finish()
        super.onBackPressed()
    }

    override fun onItemClicked(data: FindingObjectsDataClass, position: Int) {
        sayac=0
        if(sayac==0){
            list.shuffled()
            sayac++
        }

        //Eğer basması istendiği nesneye basmışsa doğru dedirt.
        //Yanlışsa bir şey yapma.
        //Ardından bir sonraki meyveyi seçmesi istensin.
        for(items in list.indices){
            if(data.soundResource==list[items].soundResource){
                mPlayer= MediaPlayer.create(this, R.raw.balontelaffuz)//Tebrikler
                mPlayer?.setOnCompletionListener {
                    mPlayer?.release()
                }
            }
            else
                hataListe.add("${items} yanlış girildi.")
            if(items+1<9){
                mPlayer= MediaPlayer.create(this, list[items+1].soundResource)//Bir sonraki tıklanılması istenen şey
                mPlayer?.setOnCompletionListener {
                    mPlayer?.release()
            }

            }
        }

    }
}