package com.ebookfrenzy.beaotis.findingobjects.fruits.groupone

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.fragment_click8.view.*


class Click8 : Fragment() {
    private var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mPlayer= MediaPlayer.create(activity, R.raw.ananas)
        mPlayer?.start()
        val view= inflater.inflate(R.layout.fragment_click8, container, false)
        view.imageViewFruitsAnanas3.setOnClickListener{
            findNavController().navigate(R.id.action_click8_to_fruitsActivity)
        }
        return view
    }

    override fun onDestroy() {

        mPlayer?.stop()

        super.onDestroy()
    }
}