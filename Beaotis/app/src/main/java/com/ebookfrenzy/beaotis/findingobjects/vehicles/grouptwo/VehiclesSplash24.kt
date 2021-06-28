package com.ebookfrenzy.beaotis.findingobjects.vehicles.grouptwo

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.request.RequestOptions
import com.ebookfrenzy.beaotis.R


class VehiclesSplash24 : Fragment() {
    private var mPlayer: MediaPlayer? = null

    val requestOption= RequestOptions().placeholder(R.drawable.e).centerCrop()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mPlayer=MediaPlayer.create(activity, R.raw.tebrikler)
        mPlayer?.start()


        Handler().postDelayed({
            findNavController().navigate(R.id.action_vehiclesSplash24_to_vehiclesActivity3)
            mPlayer?.stop()
            mPlayer?.release()
        },3000)

        return inflater.inflate(R.layout.fragment_vehicles_splash24, container, false)


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
}