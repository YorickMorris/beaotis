package com.ebookfrenzy.beaotis.findingobjects.furnitures.groupthree

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
import kotlinx.android.synthetic.main.fragment_click6.view.*
import kotlinx.android.synthetic.main.fragment_furnitures_click11.view.*
import kotlinx.android.synthetic.main.fragment_furnitures_click36.view.*


class FurnituresClick36 : Fragment() {

    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_furnituresClick36_to_furnituresClick37
    private val item = R.raw.yatak

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mediaPlay()

        val view = inflater.inflate(R.layout.fragment_furnitures_click36, container, false)
        view.imageViewFurnituresYatak3.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animation(view.imageViewFurnituresYatak3)
        }
        view.imageViewFurnituresSandalye3.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animationWrong(view.imageViewFurnituresSandalye3)
        }
        view.imageViewFurnituresMasa1.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animationWrong(view.imageViewFurnituresMasa1)
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
    fun animationWrong(v:View){
        YoYo.with(Techniques.Bounce)
                .duration(700)
                .repeat(2)
                .playOn(v)

    }


}