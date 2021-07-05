package com.ebookfrenzy.beaotis.findingobjects.fruits.groupone

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R

class SplashFragment5 : Fragment() {
    private var mPlayer: MediaPlayer? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mPlayer=MediaPlayer.create(activity, R.raw.bogurtlentelaffuz)
        mPlayer?.start()
        Handler().postDelayed({

            findNavController().navigate(R.id.action_splashFragment3_to_click5)
            mPlayer?.stop()
            mPlayer?.release()

        }, 3000)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splas5, container, false)


    }


}