package com.ebookfrenzy.beaotis.findingobjects.vehicles.grouptwo

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
import kotlinx.android.synthetic.main.fragment_click7.view.*
import kotlinx.android.synthetic.main.fragment_vehicles_click11.view.*
import kotlinx.android.synthetic.main.fragment_vehicles_click27.view.*


class VehiclesClick27 : Fragment() {

    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_vehiclesClick27_to_vehiclesClick28
    private val item = R.raw.kamyon

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mediaPlay()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vehicles_click27, container, false)

        view.imageViewVehiclesKamyon4.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animation(view.imageViewVehiclesKamyon4)
        }
        view.imageViewVehiclesGemi4.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animationWrong(view.imageViewVehiclesGemi4)
        }
        view.imageViewVehiclesMotorsiklet2.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animationWrong(view.imageViewVehiclesMotorsiklet2)
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