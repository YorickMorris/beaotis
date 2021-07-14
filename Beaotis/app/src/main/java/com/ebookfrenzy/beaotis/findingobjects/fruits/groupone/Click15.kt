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
import kotlinx.android.synthetic.main.fragment_click13.view.*
import kotlinx.android.synthetic.main.fragment_click15.view.*
import java.text.SimpleDateFormat
import java.util.*

class Click15 : Fragment() {
    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_click15_to_click16
    private val item = R.raw.elma
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
        val view = inflater.inflate(R.layout.fragment_click15, container, false)

        view.imageViewFruitsElma10.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animation(view.imageViewFruitsElma10)
            finish=System.currentTimeMillis()
            fark=finish-start
            fark /= 1000

        }
        view.imageViewFruitsArmut10.setOnClickListener {
            if(mPlayer!=null){
                mPlayer?.stop()
                mPlayer?.release()
            }
            animationWrong(view.imageViewFruitsArmut10)

        }
        view.imageViewFruitsAnanas9.setOnClickListener {
            if(mPlayer!=null){
                mPlayer?.stop()
                mPlayer?.release()
            }
            animationWrong(view.imageViewFruitsAnanas9)

        }
        view.imageViewFruitsBogurtlen5.setOnClickListener {
            if(mPlayer!=null){
                mPlayer?.stop()
                mPlayer?.release()
            }
            animationWrong(view.imageViewFruitsBogurtlen5)

        }
        view.imageViewFruitsErik1.setOnClickListener {
            if(mPlayer!=null){
                mPlayer?.stop()
                mPlayer?.release()
            }
            animationWrong(view.imageViewFruitsErik1)

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