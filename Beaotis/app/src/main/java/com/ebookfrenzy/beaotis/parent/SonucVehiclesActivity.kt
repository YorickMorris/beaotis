package com.ebookfrenzy.beaotis.parent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
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
import kotlinx.android.synthetic.main.activity_sonuc_vehicles.*

class SonucVehiclesActivity : AppCompatActivity() {
    var barEntry= arrayListOf<BarEntry>()//Bu liste ise başarı yüzdeliği olacak.
    private val db = Firebase.firestore
    private val ab="groupMixVehicles"
    private val tarihlerList2= arrayListOf<String>()
    private var basarilar= arrayListOf<Float>()
    private var sayac=1
    private var sayac1=1
    private lateinit var intentToParentActivity: Intent
    private val olumsuz="Çocuğunuzun taşıtlar konusundaki eğitimini tekrarlaması bu aktivitedeki başarısı açısından olumlu sonuçlar doğuracaktır."
    private val olumsuz2="Çocuğunuzun başarısının son günlerdeki düşüşünün sebebi dikkat dağınıklığı, uygulamayı düzenli olarak kullanmayışı veya tekrar eksikliğinden kaynaklı unutmaya başlayışı olabilir."
    private var bitirmeSayisi:Long=0
    private var tavsiyeler= arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sonuc_vehicles)

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
                                    bitirmeSayisi+=a

                                    Log.d("Başarı x: ",  "$x")
                                    basarilar.add(x.toFloat())
                                }

                            }
                            tavsiyeler.add("Çocuğunuzun bu aktivitedeki başarı oranı  %80 ve üzerinde ise başarılı olduğu anlamına gelmektedir. ")
                            tavsiyeler.add("Başarının sağlıklı bir şekilde hesaplanabilmesi için çocuğunuz gün içerisinde uygulamayı en az 5 kez tamamlamalıdır. ")
                            tavsiyeler.add("Doğru bir değerlendirme yapılabilmesi için çocuğunuzun bu uygulamayı haftada en az 35 kere kullanması gerekmektedir. ")
                            if(basarilar.size/bitirmeSayisi<=5){
                                tavsiyeler.add("Uygulamayı daha çok kullanmaya çocuğunuzu teşvik etmelisiniz.")
                            }
                            Log.d("Fark ", " İlk ve son gün arasındaki fark: " +
                                    "${basarilar[basarilar.lastIndex]-basarilar[0]}")

                            if(basarilar[basarilar.lastIndex]-basarilar[0]>=30f&&basarilar.size>=8){
                                tavsiyeler.add("Çocuğunuz nesneleri tanımada ve öğrendiklerini hatırlama ilk gündeki durumuna göre daha iyi bir sonuç almayı başarmıştır.")
                                if(comparison(basarilar)>=30f){
                                    tavsiyeler.add("Çocuğunuz nesneleri tanımada ve öğrendiklerini hatırlama konusunda olumlu yönde gelişme göstermektedir.")
                                }

                            }else if (basarilar[basarilar.lastIndex]-basarilar[0]<=-30f&& basarilar.size>=8){

                                tavsiyeler.add(olumsuz)

                                if (comparison(basarilar)<=-30f){
                                    tavsiyeler.add("Çocuğunuzun son zamanlarda ilgili aktivitede zorlanıyor olması söz konusu olup sizin gözetiminiz altında aktiviteyi tekrarlaması yararlı olacaktır. ")
                                    tavsiyeler.add(olumsuz2)
                                }

                            }


                            if(basarilar.size>=8 && basarilar.sum()/basarilar.size>=80f){
                                tavsiyeler.add("Çocuğunuz bu uygulamada yeterli başarıyı göstermiştir.")
                                tavsiyeler.add("Çocuğunuz bu aktivitede gösterdiği başarıyı diğer gruplarda da gösteriyorsa ‘Öğrenelim’ kısmındaki aktivitelere başlayabilir.")
                                Log.d("Ortalama ", " Ortalama: " +
                                        "${basarilar.sum()/basarilar.size}")
                            }

                            Log.d("Başarı ", " bugünkü başarı: " +
                                    "${basarilar.sum()/basarilar.size}")
                            if(basarilar[basarilar.lastIndex]<=50f){
                                tavsiyeler.add("Çocuğunuzun günlük başarısı beklenilenin altındadır. Çocuğunuzun uygulamayı doğru bir şekilde " +
                                        "kullandığından emin olunuz.")

                            }else if(basarilar[basarilar.lastIndex]>=80f&&bitirmeSayisi>=5){
                                tavsiyeler.add("Çocuğunuz bu aktivitede bugün gerekli başarıyı göstermektedir.")
                                tavsiyeler.add("Çocuğunuzun aktiviteleri belli bir süre tekrar etmemesi durumunda bazı nesne ve bilgileri unutma ihtimalleri bulunmaktadır. Bunun için bu aktiviteyi tekrar etmeleri önemlidir.")
                            }else if(basarilar[basarilar.lastIndex]<=30f){
                                tavsiyeler.add("Çocuğunuzun daha başarılı bir yol katedebilmesi için aktivitedeki taşıtların kullanımını günlük hayatınızda kurduğunuz cümlelerde arttırmanız tavsiye edilmektedir. Kullanacağınız cümlelerde karmaşıklık barındırmayıp sadece öğrenilmesi gereken nesnenin ismini kullanarak bu başarıyı arttırabilirsiniz.")
                                tavsiyeler.add(olumsuz)
                            }

                            val adapter= ArrayAdapter(this, R.layout.sample_text, tavsiyeler)

                            list_viewVehicles.adapter=adapter
                            adapter.notifyDataSetChanged()

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
                            barChartVehicles.data=barData
                            sayac++
                            barChartVehicles.animateY(1500)
                            barChartVehicles.setFitBars(true)
                            barChartVehicles.description.text="Başarı Seviyesi"
                            //barChart.xAxis.granularity=1f
                            barChartVehicles.xAxis.setAvoidFirstLastClipping(true)
                            //barData.barWidth=0.43f
                            barChartVehicles.axisLeft.axisMaximum=100f
                            barChartVehicles.axisLeft.axisMinimum=0f
                            barChartVehicles.axisRight.axisMaximum=100f
                            barChartVehicles.axisRight.axisMinimum=0f

                            barChartVehicles.xAxis.isGranularityEnabled=true
                            barChartVehicles.xAxis.setCenterAxisLabels(false)


                            barChartVehicles.xAxis.valueFormatter= IndexAxisValueFormatter(tarihlerList2)



                            barChartVehicles.xAxis.position= XAxis.XAxisPosition.BOTTOM
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
    fun comparison(list:ArrayList<Float>):Float{
        var a=0f
        var b=0f
        Log.d("Listenin yarısı","${list.size/2}")
        for(i in 0 until (list.size/2)){
            a+=list[i]
        }
        Log.d("Listenin ilk yarısı","$a")

        //2 olmazsa 2 f dene
        a /= (list.size / 2f)
        for(i in list.size/2 until list.size){
            b+=list[i]
        }
        b /= (list.size / 2f)
        Log.d("Listenin son yarısı","$b")

        return b-a
    }
}