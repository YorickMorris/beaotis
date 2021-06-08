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

/*
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
*/

class SplashFragment1 : Fragment() {
    private var mPlayer: MediaPlayer? = null
   /* private var param1: String? = null
    private var param2: String? = null*/

/*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
*/

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mPlayer=MediaPlayer.create(activity, R.raw.elmatelaffuz)
        mPlayer?.start()


        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashFragment1_to_click1)
        },3000)
        return inflater.inflate(R.layout.fragment_splash1, container, false)

    }

    override fun onDestroy() {
        mPlayer?.stop()
        super.onDestroy()
    }

   /* companion object {

        @JvmStatic fun newInstance(param1: String, param2: String) =
                SplashFragment1().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }*/
}