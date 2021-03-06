package com.ebookfrenzy.beaotis.findingobjects.fruits.groupthree

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
import kotlinx.android.synthetic.main.fragment_click6.view.*
import kotlinx.android.synthetic.main.fragment_click8.view.*
import kotlinx.android.synthetic.main.fragment_fruits_click38.view.*
import java.text.SimpleDateFormat
import java.util.*

class FruitsClick38 : Fragment() {

    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_fruitsClick38_to_fruitsSplash34
    private val nav2 = R.id.action_fruitsClick38_to_fruitsSplash35
    private val item = R.raw.uzum
    private var start:Long=0
    private var finish:Long=0
    private var fark:Long=0
    private val ab="groupFruits3"
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

        val view = inflater.inflate(R.layout.fragment_fruits_click38, container, false)

        view.imageViewFruitsUzum3.setOnClickListener{
            if(mPlayer!=null&& mPlayer!!.isPlaying){
                mPlayer?.stop()
                mPlayer?.release()
                mPlayer=null
            }

            finish=System.currentTimeMillis()
            fark=finish-start
            fark /= 1000
            firebaseBitirmeSuresiEntryKarar()

        }
        view.imageViewFruitsKiraz5.setOnClickListener {
            if(mPlayer!=null&& mPlayer!!.isPlaying){
                mPlayer?.stop()
                mPlayer?.release()
                mPlayer=null
            }
            animationWrong(view.imageViewFruitsKiraz5)
            firebaseYanlisEntry()
        }
        view.imageViewFruitsPortakal5.setOnClickListener {
            if(mPlayer!=null&& mPlayer!!.isPlaying){
                mPlayer?.stop()
                mPlayer?.release()
                mPlayer=null
            }
            animationWrong(view.imageViewFruitsPortakal5)
            firebaseYanlisEntry()
        }

        return view
    }
    override fun onDestroy() {
        mPlayer?.stop()
        super.onDestroy()
    }
    fun animationToFinish(v:View,nav:Int){
        YoYo.with(Techniques.Pulse )
            .duration(700)
            .repeat(2)
            .playOn(v)
        mPlayer=MediaPlayer.create(activity, R.raw.tebrikler)
        mPlayer?.start()
        mPlayer?.setOnCompletionListener {
            mPlayer?.stop()
            mPlayer?.release()
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
    fun animationWrong(v:View){
        YoYo.with(Techniques.Bounce)
                .duration(700)
                .repeat(2)
                .playOn(v)

    }
    private fun firebaseBitirmeSuresiEntryKarar(){
        if(FirebaseAuth.getInstance().currentUser!=null){
            db.collection("userIds").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).
            collection(ab).document(formatDate).get().addOnSuccessListener{
                var a=it.getLong("bitirmeSuresi")
                var b=it.getLong("yanlisSayisi")
                list= it.get("bitirmeArray") as MutableList<Int>?
                list1= it.get("yanlisArray") as MutableList<Int>?
                Log.d("Bitirme Array", "$list")
                Log.d("Yanlış Array", "$list1")
                //var c=it.data
                if (a==null){
                    a=0
                    a+=fark
                }else{
                    a+=fark
                }


                if (list!=null){
                    if (list?.size!! >=5){
                        list!!.removeFirst()
                    }
                }
                if (list1!=null){
                    if (list1?.size!! >=5){
                        list1!!.removeFirst()
                    }
                }
                if(list==null){
                    list= arrayListOf()

                }
                if(list1==null){
                    list1= arrayListOf()

                }
                list?.add(a.toInt())
                list1?.add(b!!.toInt())


                if (list1!!.isEmpty()){
                    list1!!.add(0)
                }

                Log.d("Bitirme Süresi", "$list")
                val sure= hashMapOf(
                    "bitirmeSuresi" to a,
                    "yanlisSayisi" to b,
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

                if (list != null&&list1!=null) {
                    if(list!!.sum()/ list!!.size<=40&& list1!!.sum()/ list1!!.size<10&&list!!.size>=5){
                        view?.let{it2->animationToFinish(it2.imageViewFruitsUzum3,nav2)}
                    }else
                        view?.let { it1 -> animationToFinish(it1.imageViewFruitsUzum3,nav) }
                }
            }.addOnFailureListener {
                Toast.makeText(view?.context,"Yapma süresi eklenemedi.", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun firebaseYanlisEntry(){
        if(FirebaseAuth.getInstance().currentUser!=null){
            db.collection("userIds").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).
            collection(ab).document(formatDate).get().addOnSuccessListener{
                var a=it.getLong("bitirmeSuresi")
                var yanlis=it.getLong("yanlisSayisi")
                list= it.get("bitirmeArray") as MutableList<Int>?
                list1= it.get("yanlisArray") as MutableList<Int>?
                if (yanlis==null){
                    yanlis=0
                    yanlis+=1
                }else
                    yanlis+=1
                if (list1!=null){
                    if (list1?.size!! >=5){
                        list1!!.removeFirst()
                    }
                }
                if(list==null){
                    list= arrayListOf()

                }
                if(list1==null){
                    list1= arrayListOf()

                }
                list1?.add(yanlis.toInt())
                Log.d("Yanlış Sayısı", "$list1")
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
                Toast.makeText(view?.context,"Yanlış sayısı eklenemedi.", Toast.LENGTH_SHORT).show()
            }
        }
    }


}