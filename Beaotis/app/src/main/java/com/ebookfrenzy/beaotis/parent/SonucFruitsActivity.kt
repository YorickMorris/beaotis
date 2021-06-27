package com.ebookfrenzy.beaotis.parent

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ebookfrenzy.beaotis.R
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sonuc_fruits.*


class SonucFruitsActivity : AppCompatActivity() {
    var barEntry= arrayListOf<BarEntry>()//Bu liste ise başarı yüzdeliği olacak.
    private val db = Firebase.firestore
    private val ab="groupMixFruits"
    val tarihlerList2= arrayListOf<String>()
    var basarilar= arrayListOf<Float>()
    var sayac=1
    var sayac1=1




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc_fruits)
        
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
                            val barDataSet=BarDataSet(barEntry,"Başarı Oranları")
                            barDataSet.valueTextSize=10f
                            barDataSet.setColors(*ColorTemplate.MATERIAL_COLORS)

                            val barData=BarData(barDataSet)
                            barChart.data=barData
                            sayac++
                            barChart.animateY(1500)
                            barChart.setFitBars(true)
                            barChart.description.text="Başarı Seviyesi"
                            //barChart.xAxis.granularity=1f
                            barChart.xAxis.setAvoidFirstLastClipping(true)
                            //barData.barWidth=0.43f
                            barChart.axisLeft.axisMaximum=100f
                            barChart.axisLeft.axisMinimum=0f

                            barChart.xAxis.isGranularityEnabled=true
                            barChart.xAxis.setCenterAxisLabels(false)


                            barChart.xAxis.valueFormatter=IndexAxisValueFormatter(tarihlerList2)



                            barChart.xAxis.position= XAxis.XAxisPosition.BOTTOM
                            Log.d("Listenerİçi", tarihlerList2.toString())

                        }


                    } else {
                        Log.d("a", "Error getting documents: ")
                    }
                }
            Log.d("ListenerDışı", tarihlerList2.toString())


        }


    }
    /*fun foo(callback:(MutableList<String>) -> Unit) {

    }*/
    /*fun getAreaCount(tarihler:ArrayList<String>):ArrayList<String>{

        for (i in 0 until tarihler.size) label.add(areaList.get(i).getTopicName()){

        }
        return tarihler
    }*/

}