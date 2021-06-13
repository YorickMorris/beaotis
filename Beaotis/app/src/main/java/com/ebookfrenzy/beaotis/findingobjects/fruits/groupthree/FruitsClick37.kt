package com.ebookfrenzy.beaotis.findingobjects.fruits.groupthree

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.fragment_click7.view.*
import kotlinx.android.synthetic.main.fragment_fruits_click37.view.*


class FruitsClick37 : Fragment() {

    private var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mPlayer=MediaPlayer.create(activity, R.raw.portakal)
        mPlayer?.start()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fruits_click37, container, false)

        view.imageViewFruitsPortakal4.setOnClickListener {
            findNavController().navigate(R.id.action_fruitsClick37_to_fruitsClick38)
        }

        return view
    }
    override fun onDestroy() {

        mPlayer?.stop()

        super.onDestroy()
    }


}