package com.ebookfrenzy.beaotis.findingobjects.vehicles.groupone

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
import kotlinx.android.synthetic.main.fragment_vehicles_click11.view.*
import kotlinx.android.synthetic.main.fragment_vehicles_click13.view.*


class VehiclesClick13 : Fragment() {

    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_vehiclesClick13_to_vehiclesClick14
    private val item = R.raw.araba

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mediaPlay()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vehicles_click13, container, false)

        view.imageViewVehiclesAraba1.setOnClickListener{
            mPlayer?.stop()
            mPlayer?.release()
            animation(view.imageViewVehiclesAraba1)
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