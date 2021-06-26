package com.ebookfrenzy.beaotis.findingobjects.fruits

import android.content.Intent
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.MediaPlayer
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ServerTimestamp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Month
import java.util.*

class GroupMixed : AppCompatActivity(),IFindingObjectsMixedOnClickListener,IFindingObjectsMixedGenerator {
    private lateinit var intentToFruitsActivity: Intent
    private lateinit var recyclerView: RecyclerView
    private var mPlayer: MediaPlayer?=null
    val list:MutableList<Int> = getSoundResources(mixed_generateList())
    var hataListe = mutableListOf<String>()
    var sayac = 0
    private var sayacDogru:Int=0
    private var sayacYanlis:Int=0
    private val timestamp: FieldValue =FieldValue.serverTimestamp()
    private val db = Firebase.firestore
    private var activityAcmaSayisi:Int=1
    var sayac1=0
    private val c: Date = Calendar.getInstance().time
    private val df: SimpleDateFormat = SimpleDateFormat("dd-MMM-yyyy", Locale.CANADA)
    private val formatDate=df.format(c)
    private val ab="groupMixFruits"
    private var x:Long?=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_mixed)



      /*  val docRef = db.collection("cities").document("BJ")

        val updates = hashMapOf<String, Any>(
            "capital" to FieldValue.delete()
        )

        docRef.update(updates).addOnCompleteListener { }*/


        mPlayer = MediaPlayer.create(this, list[0])
        mPlayer?.start()
        mPlayer?.setOnCompletionListener {
            Toast.makeText(this,"İlk ses tamamlandı.",Toast.LENGTH_SHORT).show()
            mPlayer?.stop()
            mPlayer?.release()
            mPlayer=null
        }

        intentToFruitsActivity = Intent(this, FruitsActivity::class.java)

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

    override fun onItemClicked(data: FindingObjectsDataClass, position: Int,imageView:ImageView) {
        //mPlayer?.stop()
        //mPlayer?.release()
        if(sayac==8 && data.soundResource==list[sayac]){
            mPlayer = MediaPlayer.create(this, R.raw.tebrikler)
            mPlayer?.start()
            mPlayer?.setOnCompletionListener {
                mPlayer?.stop()
                mPlayer?.release()
                mPlayer=null
            }
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
        Log.d("TAGLA", "onDestroy Çağrıldı")
        Log.d("TAGLA", "$sayacDogru")
        Log.d("TAGLA", "$sayacYanlis")

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
        YoYo.with(Techniques.Bounce)//Hangi animasyon konulacak(Yanlış olduğunu göstermek için)
            .duration(700)
            .repeat(2)
            .playOn(imageView)
    }

}