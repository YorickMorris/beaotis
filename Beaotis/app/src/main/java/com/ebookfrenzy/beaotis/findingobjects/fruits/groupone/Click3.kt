package com.ebookfrenzy.beaotis.findingobjects.fruits.groupone

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.fragment_click1.view.*
import kotlinx.android.synthetic.main.fragment_click3.*
import kotlinx.android.synthetic.main.fragment_click3.view.*

class Click3 : Fragment() {

    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_click3_to_click4
    private val item = R.raw.elma

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mediaPlay()


        val view= inflater.inflate(R.layout.fragment_click3, container, false)
        view.imageViewFruitsElma1.setOnClickListener{
            mPlayer?.stop()
            mPlayer?.release()
            animation(view.imageViewFruitsElma1)
        }
        view.imageViewFruitsArmut1.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animationWrong(imageViewFruitsArmut1)
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
        YoYo.with(Techniques.Pulse)
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
    fun animationWrong(v:View){
        YoYo.with(Techniques.Pulse)//Hangi animasyon konulacak(Yanlış olduğunu göstermek için)
            .duration(700)
            .repeat(2)
            .playOn(v)
        mPlayer=MediaPlayer.create(activity, R.raw.tebrikler)//Yanlış diyen ses olacak mı?
        mPlayer?.start()
        mPlayer?.setOnCompletionListener {
            mPlayer?.stop()
            mPlayer?.release()
            mPlayer=null
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

}