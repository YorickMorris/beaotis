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
import kotlinx.android.synthetic.main.fragment_click16.view.*
import kotlinx.android.synthetic.main.fragment_click17.view.*
import java.text.SimpleDateFormat
import java.util.*


class Click17 : Fragment() {
    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_click17_to_click18
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
        start=System.currentTimeMillis()
        mediaPlay()
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_click17, container, false)

        view.imageViewFruitsAnanas11.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animation(view.imageViewFruitsAnanas11)
            finish=System.currentTimeMillis()
            fark=finish-start
            fark /= 1000

        }
        view.imageViewFruitsElma12.setOnClickListener {
            if(mPlayer!=null){
                mPlayer?.stop()
                mPlayer?.release()
            }
            animationWrong(view.imageViewFruitsElma12)

        }
        view.imageViewFruitsArmut12.setOnClickListener {
            if(mPlayer!=null){
                mPlayer?.stop()
                mPlayer?.release()
            }
            animationWrong(view.imageViewFruitsArmut12)

        }
        view.imageViewFruitsBogurtlen7.setOnClickListener {
            if(mPlayer!=null){
                mPlayer?.stop()
                mPlayer?.release()
            }
            animationWrong(view.imageViewFruitsBogurtlen7)

        }
        view.imageViewFruitsErik3.setOnClickListener {
            if(mPlayer!=null){
                mPlayer?.stop()
                mPlayer?.release()
            }
            animationWrong(view.imageViewFruitsErik3)

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
    fun animation(v:View){
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


}