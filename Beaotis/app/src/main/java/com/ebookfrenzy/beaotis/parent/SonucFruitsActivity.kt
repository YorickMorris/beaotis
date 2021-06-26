package com.ebookfrenzy.beaotis.parent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.beaotis.R
import com.github.mikephil.charting.data.BarEntry

class SonucFruitsActivity : AppCompatActivity() {
    var barEntry= arrayListOf<BarEntry>()//Bu liste ise başarı yüzdeliği olacak.
    var tarihler= arrayListOf<String>()//Tarihleri bu listeye atacağız
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc_fruits)
        


    }
}