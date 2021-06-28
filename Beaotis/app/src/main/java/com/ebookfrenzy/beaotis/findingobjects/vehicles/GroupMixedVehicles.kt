package com.ebookfrenzy.beaotis.findingobjects.vehicles

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.FindingObjectsDataClass
import com.ebookfrenzy.beaotis.findingobjects.FindingObjectsMixedRecyclerView
import com.ebookfrenzy.beaotis.findingobjects.IFindingObjectsMixedGenerator
import com.ebookfrenzy.beaotis.findingobjects.IFindingObjectsMixedOnClickListener
import com.ebookfrenzy.beaotis.findingobjects.furnitures.FurnituresActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class GroupMixedVehicles : AppCompatActivity(), IFindingObjectsMixedOnClickListener,
    IFindingObjectsMixedGenerator {
    private lateinit var intentToVehiclesActivity: Intent
    private lateinit var recyclerView: RecyclerView
    private var mPlayer: MediaPlayer?=null
    val list:MutableList<Int> = getSoundResources(mixed_vehicles())
    var sayac = 0
    private var sayacDogru:Int=0
    private var sayacYanlis:Int=0
    private val db = Firebase.firestore
    private val c: Date = Calendar.getInstance().time
    private val df: SimpleDateFormat = SimpleDateFormat("dd-MMM-yyyy", Locale.CANADA)
    private val formatDate=df.format(c)
    private val ab="groupMixVehicles"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_mixed_vehicles)

        mPlayer = MediaPlayer.create(this, list[0])
        mPlayer?.start()
        mPlayer?.setOnCompletionListener {
            Toast.makeText(this,"İlk ses tamamlandı.", Toast.LENGTH_SHORT).show()
            mPlayer?.stop()
            mPlayer?.release()
            mPlayer=null
        }

        intentToVehiclesActivity = Intent(this, VehiclesActivity::class.java)

        recyclerView = findViewById(R.id.vehiclesMixedRecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        val adapter = FindingObjectsMixedRecyclerView(mixed_vehicles(), this)

        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

    }
    override fun onBackPressed() {
        startActivity(intentToVehiclesActivity)
        finish()
        super.onBackPressed()
    }

    override fun onItemClicked(data: FindingObjectsDataClass, position: Int,imageView: ImageView) {
        if(sayac==8 && data.soundResource==list[sayac]){
            sayacDogru++
            animation(imageView)
            mPlayer = MediaPlayer.create(this, R.raw.tebrikler)
            mPlayer?.start()
            mPlayer?.setOnCompletionListener {
                mPlayer?.stop()
                mPlayer?.release()
                mPlayer=null
                onBackPressed()
            }
        }else if(sayac==8 && data.soundResource!=list[sayac]){
            animationWrong(imageView)
            sayacYanlis++
        }
        if(sayac!=8){
            if (data.soundResource == list[sayac]) {
                sayacDogru++
                mPlayer = MediaPlayer.create(this, R.raw.tebrikler)
                mPlayer?.start()
                animation(imageView)
                mPlayer?.setOnCompletionListener {
                    mPlayer?.stop()
                    mPlayer?.release()
                    mPlayer=null

                    mPlayer = MediaPlayer.create(this, list[sayac+1])
                    mPlayer?.start()
                    mPlayer?.setOnCompletionListener {
                        mPlayer?.stop()
                        mPlayer?.release()
                        mPlayer=null

                    }
                    sayac++
                }

            } else{
                animationWrong(imageView)
                sayacYanlis++
            }
        }
    }
    override fun onStop() {
        mPlayer?.release()
        super.onStop()
    }

    override fun onDestroy() {
        if(FirebaseAuth.getInstance().currentUser!=null){
            db.collection("userIds").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).
            collection(ab).document(formatDate).get().addOnSuccessListener {
                var a=it.getLong("bitirmesayisi")
                if (a==null){
                    a=0
                    a+=1
                }else
                    a++

                Log.d("A degeri", "$a")
                var b=it.getLong("dogrusayisi")
                if (b==null){
                    b=0
                    b+=sayacDogru
                }else
                    b+=sayacDogru

                var c=it.getLong("yanlissayisi")
                if (c==null){
                    c=0
                    c+=sayacYanlis
                }else
                    c+=sayacYanlis

                val basari= hashMapOf(
                        "bitirmesayisi" to a,
                        "dogrusayisi" to b,
                        "yanlissayisi" to c
                )
                if (FirebaseAuth.getInstance().currentUser!=null){
                    db.collection("userIds").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).collection(
                            ab
                    ).document(formatDate).set(basari).addOnSuccessListener {
                        Log.d("TAGLA", "DocumentSnapshot successfully written! But bitirmeSayisiAlreadyExist")
                    }
                }

            }.addOnFailureListener {
                Log.d("TAGLA", "FireBase İşlemi Başarısız")
            }

        }

        super.onDestroy()
    }
    fun animation(imageView: ImageView){
        YoYo.with(Techniques.Pulse )
                .duration(700)
                .repeat(2)
                .playOn(imageView)

    }
    fun animationWrong(imageView: ImageView){
        YoYo.with(Techniques.Bounce)
                .duration(700)
                .repeat(2)
                .playOn(imageView)
    }

    override fun onStart() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onStart()
    }
}