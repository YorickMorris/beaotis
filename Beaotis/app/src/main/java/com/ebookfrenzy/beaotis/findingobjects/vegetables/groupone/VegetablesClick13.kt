package com.ebookfrenzy.beaotis.findingobjects.vegetables.groupone

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
import kotlinx.android.synthetic.main.fragment_click3.view.*
import kotlinx.android.synthetic.main.fragment_furnitures_click13.view.*
import kotlinx.android.synthetic.main.fragment_vegetables_click11.view.*
import kotlinx.android.synthetic.main.fragment_vegetables_click13.view.*


class VegetablesClick13 : Fragment() {

    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_vegetablesClick13_to_vegetablesClick14
    private val item = R.raw.domates

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mediaPlay()


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vegetables_click13, container, false)

        view.imageViewVegetablesDomates1.setOnClickListener{
            mPlayer?.stop()
            mPlayer?.release()
            animation(view.imageViewVegetablesDomates1)
        }
        view.imageViewVegetablesHavuc1.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animationWrong(view.imageViewVegetablesHavuc1)
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
        YoYo.with(Techniques.Bounce)//Hangi animasyon konulacak(Yanlış olduğunu göstermek için)
                .duration(700)
                .repeat(2)
                .playOn(v)
    }


}