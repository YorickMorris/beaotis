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


class SplashFragment2 : Fragment() {
    private var mPlayer: MediaPlayer? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mPlayer=MediaPlayer.create(activity, R.raw.armuttelaffuz)
        mPlayer?.start()

        Handler().postDelayed({

            findNavController().navigate(R.id.action_splashFragment2_to_click2)
            mPlayer?.stop()
            mPlayer?.release()
        }, 3000)

        return inflater.inflate(R.layout.fragment_splash2, container, false)
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