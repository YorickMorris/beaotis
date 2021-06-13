package com.ebookfrenzy.beaotis.findingobjects.vegetables.groupthree

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.request.RequestOptions
import com.ebookfrenzy.beaotis.R


class VegetablesSplash34 : Fragment() {

    val requestOption= RequestOptions().placeholder(R.drawable.e).centerCrop()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vegetables_splash34, container, false)

        Handler().postDelayed({

            findNavController().navigate(R.id.action_vegetablesSplash34_to_vegetablesActivity2)


        }, 3000)

        return view
    }


}