package com.ebookfrenzy.beaotis.findingobjects.fruits.groupone

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.ebookfrenzy.beaotis.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_click6.view.*
import kotlinx.android.synthetic.main.fragment_click7.view.*
import kotlinx.android.synthetic.main.fragment_click8.view.*
import java.text.SimpleDateFormat
import java.util.*


class Click8 : Fragment() {
    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_click8_to_splashFragment4
    private val nav2 = R.id.action_click8_to_splashFragment5
    private val item = R.raw.ananas
    private var start:Long=0
    private var finish:Long=0
    private var fark:Long=0
    private val ab="groupFruits1"
    private val db = Firebase.firestore
    private val c: Date = Calendar.getInstance().time
    private val df: SimpleDateFormat = SimpleDateFormat("dd-MMM-yyyy", Locale.CANADA)
    private val formatDate=df.format(c)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mediaPlay()

        val view= inflater.inflate(R.layout.fragment_click8, container, false)
        view.imageViewFruitsAnanas3.setOnClickListener{
            mPlayer?.stop()
            mPlayer?.release()

            finish=System.currentTimeMillis()
            fark=finish-start
            fark /= 1000
            firebaseBitirmeSuresiEntryKarar()

        }
        view.imageViewFruitsElma5.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animationWrong(view.imageViewFruitsElma5)
            firebaseYanlisEntry()
        }
        view.imageViewFruitsArmut5.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animationWrong(view.imageViewFruitsArmut5)
            firebaseYanlisEntry()
        }
        return view
    }

    override fun onDestroy() {

        mPlayer?.stop()
        mPlayer?.release()
        super.onDestroy()
    }
    override fun onDetach() {
        mPlayer?.stop()
        mPlayer?.release()
        super.onDetach()
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
                if (a==null){
                    a=0
                    a+=fark
                }else
                    a+=fark

                Log.d("Bitirme Süresi", "$fark")
                val sure= hashMapOf(
                    "bitirmeSuresi" to a
                )
                if (FirebaseAuth.getInstance().currentUser!=null){
                    db.collection("userIds").document(FirebaseAuth.getInstance().currentUser?.uid.toString()).collection(
                        ab
                    ).document(formatDate).set(sure).addOnSuccessListener {
                        Log.d("TAGLA", "DocumentSnapshot successfully written! But bitirmeSayisiAlreadyExist")
                    }
                }
                if (b != null) {
                    if(a<80&&b<10){
                        view?.let{t1->animationToFinish(t1,nav2)}
                    }else
                        view?.let { it1 -> animationToFinish(it1,nav) }


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
                var yanlis=it.getLong("yanlisSayisi")
                if (yanlis==null){
                    yanlis=0
                    yanlis+=1
                }else
                    yanlis+=1

                Log.d("Yanlış Sayısı", "$yanlis")
                val sure= hashMapOf(
                    "yanlisSayisi" to yanlis
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