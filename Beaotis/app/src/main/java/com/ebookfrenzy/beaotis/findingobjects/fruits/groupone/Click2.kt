package com.ebookfrenzy.beaotis.findingobjects.fruits.groupone

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.ebookfrenzy.beaotis.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_click1.view.*
import kotlinx.android.synthetic.main.fragment_click2.view.*
import java.text.SimpleDateFormat
import java.util.*


class Click2 : Fragment() {
    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_click2_to_click3
    private val item = R.raw.armut
    private var start:Long=0
    private var finish:Long=0
    private var fark:Long=0
    private val ab="groupFruits1"
    private val db = Firebase.firestore
    private val c: Date = Calendar.getInstance().time
    private val df: SimpleDateFormat = SimpleDateFormat("dd-MMM-yyyy", Locale.CANADA)
    private val formatDate=df.format(c)
    private var list:MutableList<Int>?=null
    private var list1:MutableList<Int>?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        start=System.currentTimeMillis()
        mediaPlay()

        val view= inflater.inflate(R.layout.fragment_click2, container, false)

        view.imageViewFruitsArmut.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animation(view.imageViewFruitsArmut)
            finish=System.currentTimeMillis()
            fark=finish-start
            fark /= 1000
            firebaseBitirmeSuresiEntry()
        }
        return view
    }


    override fun onDetach() {
        mPlayer?.stop()
        mPlayer?.release()
        super.onDetach()
    }

    fun animation(v:View){
        YoYo.with(Techniques.Pulse )
            .duration(700)
            .repeat(2)
            .playOn(v)
        mPlayer=MediaPlayer.create(activity, R.raw.tebrikler)
        mPlayer?.start()
        mPlayer?.setOnCompletionListener {
            if(mPlayer!=null&& mPlayer!!.isPlaying){
                mPlayer?.stop()
                mPlayer?.release()
                mPlayer=null
            }
            mPlayer=null
            findNavController().navigate(nav)
        }
    }

    fun mediaPlay(){
        mPlayer=MediaPlayer.create(activity, item)
        mPlayer?.start()
        mPlayer?.setOnCompletionListener {
            mPlayer?.stop()
            mPlayer?.release()
            mPlayer=null
        }
    }
    private fun firebaseBitirmeSuresiEntry(){
        if(FirebaseAuth.getInstance().currentUser!=null){
            db.collection("userIds").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).
            collection(ab).document(formatDate).get().addOnSuccessListener{
                var a=it.getLong("bitirmeSuresi")
                var yanlis=it.getLong("yanlisSayisi")
                list= it.get("bitirmeArray") as MutableList<Int>?
                list1= it.get("yanlisArray") as MutableList<Int>?
                if (a==null){
                    a=0
                    a+=fark
                }else
                    a+=fark

                if(list==null){
                    list= arrayListOf()

                }
                if(list1==null){
                    list1= arrayListOf()

                }
                Log.d("Bitirme Süresi", "$fark")
                val sure= hashMapOf(
                    "bitirmeSuresi" to a,
                    "yanlisSayisi" to yanlis,
                    "bitirmeArray" to list,
                    "yanlisArray" to list1

                )

                if (FirebaseAuth.getInstance().currentUser!=null){
                    db.collection("userIds").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).collection(
                        ab
                    ).document(formatDate).set(sure).addOnSuccessListener {
                        Log.d("TAGLA", "DocumentSnapshot successfully written! But bitirmeSayisiAlreadyExist")
                    }
                }
            }.addOnFailureListener {
                Toast.makeText(view?.context,"Yapma süresi eklenemedi.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}