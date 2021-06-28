package com.ebookfrenzy.beaotis.findingobjects.vegetables.grouptwo

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
import kotlinx.android.synthetic.main.fragment_furnitures_click21.view.*
import kotlinx.android.synthetic.main.fragment_vegetables_click11.view.*
import kotlinx.android.synthetic.main.fragment_vegetables_click21.view.*

class VegetablesClick21 : Fragment() {

    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_vegetablesClick21_to_vegetablesSplash22
    private val item = R.raw.biber

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mediaPlay()

        val view = inflater.inflate(R.layout.fragment_vegetables_click21, container, false)

        view.imageViewVegetablesBiber.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animation(view.imageViewVegetablesBiber)
        }

        return view
    }
    override fun onDestroy() {
        mPlayer?.stop()
        super.onDestroy()
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