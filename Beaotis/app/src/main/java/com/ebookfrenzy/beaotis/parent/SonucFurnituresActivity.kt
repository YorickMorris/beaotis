package com.ebookfrenzy.beaotis.parent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ebookfrenzy.beaotis.R
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sonuc_fruits.*
import kotlinx.android.synthetic.main.activity_sonuc_fruits.barChart
import kotlinx.android.synthetic.main.activity_sonuc_furnitures.*

class SonucFurnituresActivity : AppCompatActivity() {

    var barEntry= arrayListOf<BarEntry>()//Bu liste ise başarı yüzdeliği olacak.
    private val db = Firebase.firestore
    private val ab="groupMixFurnitures"
    private val tarihlerList2= arrayListOf<String>()
    private var basarilar= arrayListOf<Float>()
    private var sayac=1
    private var sayac1=1
    private lateinit var intentToParentActivity: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc_furnitures)
        intentToParentActivity=Intent(this, ParentActivity::class.java)

        if(FirebaseAuth.getInstance().currentUser!=null&& sayac1==1){
            db.collection("userIds").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).
            collection(ab).get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        sayac1++

                        for (document in task.result!!) {
                            tarihlerList2.add(document.id)
                            val a=document.getLong("bitirmesayisi")
                            val b=document.getLong("dogrusayisi")
                            val c=document.getLong("yanlissayisi")

                            if(a!=null && b!=null && c!=null){
                                a.toFloat()
                                b.toFloat()
                                c.toFloat()
                                Log.d("a,b,c: ",  "$a,$b,$c")
                                val x=((b/(c+(a*9f)))* 100f).toDouble()
                                Log.d("Başarı x: ",  "$x")
                                basarilar.add(x.toFloat())
                            }
                        }
                        for (items in tarihlerList2.indices){
                            Log.d("İtemler: ",  "$items")
                            barEntry.add(BarEntry(items.toFloat(),basarilar[items]))
                            Log.d("Başarılar ",  "$basarilar")
                            Log.d("Tarihler İndisleri ",  "${tarihlerList2.indices}")
                        }
                        Log.d("Sayac: ",  "$sayac")
                        if(sayac<=tarihlerList2.size){
                            val barDataSet= BarDataSet(barEntry,"Başarı Oranları")
                            barDataSet.valueTextSize=10f
                            barDataSet.setColors(*ColorTemplate.MATERIAL_COLORS)

                            val barData= BarData(barDataSet)
                            barChartFurnitures.data=barData
                            sayac++
                            barChartFurnitures.animateY(1500)
                            barChartFurnitures.setFitBars(true)
                            barChartFurnitures.description.text="Başarı Seviyesi"
                            //barChart.xAxis.granularity=1f
                            barChartFurnitures.xAxis.setAvoidFirstLastClipping(true)
                            //barData.barWidth=0.43f
                            barChartFurnitures.axisLeft.axisMaximum=100f
                            barChartFurnitures.axisLeft.axisMinimum=0f
                            barChartFurnitures.axisRight.axisMaximum=100f
                            barChartFurnitures.axisRight.axisMinimum=0f

                            barChartFurnitures.xAxis.isGranularityEnabled=true
                            barChartFurnitures.xAxis.setCenterAxisLabels(false)


                            barChartFurnitures.xAxis.valueFormatter= IndexAxisValueFormatter(tarihlerList2)



                            barChartFurnitures.xAxis.position= XAxis.XAxisPosition.BOTTOM
                            Log.d("Listenerİçi", tarihlerList2.toString())

                        }


                    } else {
                        Log.d("a", "Error getting documents: ")
                    }
                }
            Log.d("ListenerDışı", tarihlerList2.toString())


        }
    }
    override fun onBackPressed() {
        startActivity(intentToParentActivity)
        finish()
        super.onBackPressed()
    }
}