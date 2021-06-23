package com.ebookfrenzy.beaotis.findingobjects.furnitures.groupone

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
import kotlinx.android.synthetic.main.fragment_click8.view.*
import kotlinx.android.synthetic.main.fragment_furnitures_click11.view.*
import kotlinx.android.synthetic.main.fragment_furnitures_click18.view.*


class FurnituresClick18 : Fragment() {

    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_furnituresClick18_to_furnituresSplash14
    private val item = R.raw.kasik

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mediaPlay()


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_furnitures_click18, container, false)

        view.imageViewFurnituresKasik3.setOnClickListener{
            mPlayer?.stop()
            mPlayer?.release()
            animation(view.imageViewFurnituresKasik3)
        }
        view.imageViewFurnituresBicak5.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animationWrong(view.imageViewFurnituresBicak5)
        }
        view.imageViewFurnituresCatal5.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animationWrong(view.imageViewFurnituresCatal5)
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