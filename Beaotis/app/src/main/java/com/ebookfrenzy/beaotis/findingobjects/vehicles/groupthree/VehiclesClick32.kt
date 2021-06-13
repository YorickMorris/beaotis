package com.ebookfrenzy.beaotis.findingobjects.vehicles.groupthree

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.fragment_click2.view.*
import kotlinx.android.synthetic.main.fragment_vehicles_click32.view.*


class VehiclesClick32 : Fragment() {

    private var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mPlayer=MediaPlayer.create(activity, R.raw.tren)
        mPlayer?.start()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vehicles_click32, container, false)

        view.imageViewVehiclesTren.setOnClickListener {
            findNavController().navigate(R.id.action_vehiclesClick32_to_vehiclesClick33)

        }
        return view
    }

    override fun onDestroy() {

        mPlayer?.stop()

        super.onDestroy()
    }


}