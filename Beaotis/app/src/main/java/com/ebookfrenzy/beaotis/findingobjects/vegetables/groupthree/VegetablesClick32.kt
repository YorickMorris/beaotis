package com.ebookfrenzy.beaotis.findingobjects.vegetables.groupthree

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.fragment_furnitures_click32.view.*
import kotlinx.android.synthetic.main.fragment_vegetables_click32.view.*


class VegetablesClick32 : Fragment() {

    private var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mPlayer=MediaPlayer.create(activity, R.raw.salatalik)
        mPlayer?.start()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vegetables_click32, container, false)

        view.imageViewVegetablesSalatalik.setOnClickListener {
            findNavController().navigate(R.id.action_vegetablesClick32_to_vegetablesClick33)

        }
        return view
    }
    override fun onDestroy() {

        mPlayer?.stop()

        super.onDestroy()
    }


}