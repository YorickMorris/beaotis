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
import kotlinx.android.synthetic.main.fragment_click2.view.*


class Click2 : Fragment() {
    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_click2_to_click3
    private val item = R.raw.armut
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mediaPlay()



        val view= inflater.inflate(R.layout.fragment_click2, container, false)

        view.imageViewFruitsArmut.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animation(view.imageViewFruitsArmut)
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

}