package com.ebookfrenzy.beaotis.findingobjects.vegetables.grouptwo

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R


class VegetablesSplash23 : Fragment() {

    private var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mPlayer=MediaPlayer.create(activity, R.raw.sarimsaktelaffuz)
        mPlayer?.start()
        Handler().postDelayed({
            findNavController().navigate(R.id.action_vegetablesSplash23_to_vegetablesClick25)
        }, 3000)

        return inflater.inflate(R.layout.fragment_vegetables_splash23, container, false)
    }
    override fun onDestroy() {
        mPlayer?.stop()
        super.onDestroy()
    }
}