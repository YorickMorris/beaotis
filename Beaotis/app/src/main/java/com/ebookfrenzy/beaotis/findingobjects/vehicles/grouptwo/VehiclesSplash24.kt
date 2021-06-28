package com.ebookfrenzy.beaotis.findingobjects.vehicles.grouptwo

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

    val requestOption= RequestOptions().placeholder(R.drawable.e).centerCrop()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_vehicles_splash24, container, false)

        Handler().postDelayed({
            findNavController().navigate(R.id.action_vehiclesSplash24_to_vehiclesActivity3)
        }, 3000)

        return view
    }
}