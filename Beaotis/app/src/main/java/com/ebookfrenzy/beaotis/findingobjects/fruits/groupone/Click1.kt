package com.ebookfrenzy.beaotis.findingobjects.fruits.groupone

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.fragment_click1.view.*

/*
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
*/

class Click1 : Fragment() {
    private var mPlayer: MediaPlayer? = null
/*
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mPlayer=MediaPlayer.create(activity, R.raw.elmatelaffuz)
        mPlayer?.start()


        val view= inflater.inflate(R.layout.fragment_click1, container, false)
        view.imageViewFruitsElma.setOnClickListener {
            findNavController().navigate(R.id.action_click1_to_splashFragment2)
        }

        return view
    }


    override fun onDestroy() {

        mPlayer?.stop()

        super.onDestroy()
    }

/*    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Click1().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}