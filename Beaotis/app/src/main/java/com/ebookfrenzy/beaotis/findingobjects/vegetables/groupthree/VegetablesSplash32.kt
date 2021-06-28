package com.ebookfrenzy.beaotis.findingobjects.vegetables.groupthree

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R


class VegetablesSplash32 : Fragment() {

    private var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mPlayer=MediaPlayer.create(activity, R.raw.salataliktelaffuz)
        mPlayer?.start()

        Handler().postDelayed({

            findNavController().navigate(R.id.action_vegetablesSplash32_to_vegetablesClick32)
        }, 3000)

        return inflater.inflate(R.layout.fragment_vegetables_splash32, container, false)
    }
    override fun onDestroy() {
        mPlayer?.stop()
        super.onDestroy()
    }
}