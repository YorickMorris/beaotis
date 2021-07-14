package com.ebookfrenzy.beaotis.findingobjects.fruits.groupthree

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R


class FruitsSplash35 : Fragment() {
    private var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mPlayer=MediaPlayer.create(activity, R.raw.kavuntelaffuz)
        mPlayer?.start()
        Handler().postDelayed({

            findNavController().navigate(R.id.action_fruitsSplash35_to_fruitsClick39)
            mPlayer?.stop()
            mPlayer?.release()

        }, 3000)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fruits_splash35, container, false)
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