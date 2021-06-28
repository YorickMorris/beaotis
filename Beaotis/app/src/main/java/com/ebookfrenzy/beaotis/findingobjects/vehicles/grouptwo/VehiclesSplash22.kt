package com.ebookfrenzy.beaotis.findingobjects.vehicles.grouptwo

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R


class VehiclesSplash22 : Fragment() {

    private var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mPlayer=MediaPlayer.create(activity, R.raw.kamyontelaffuz)
        mPlayer?.start()

        Handler().postDelayed({
            findNavController().navigate(R.id.action_vehiclesSplash22_to_vehiclesClick22)
        }, 3000)

        return inflater.inflate(R.layout.fragment_vehicles_splash22, container, false)
    }
    override fun onDestroy() {

        mPlayer?.stop()

        super.onDestroy()
    }
}