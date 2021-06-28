package com.ebookfrenzy.beaotis.findingobjects.fruits.grouptwo

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.request.RequestOptions
import com.ebookfrenzy.beaotis.R


class FruitsSplash24 : Fragment() {

    val requestOption= RequestOptions().placeholder(R.drawable.e).centerCrop()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_fruits_splash24, container, false)

        Handler().postDelayed({
            findNavController().navigate(R.id.action_fruitsSplash24_to_fruitsActivity3)
        }, 3000)

        return view
    }


}