package com.ebookfrenzy.beaotis.findingobjects.fruits.grouptwo

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.fragment_click8.view.*
import kotlinx.android.synthetic.main.fragment_fruits_click28.view.*


class FruitsClick28 : Fragment() {
    private var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mPlayer= MediaPlayer.create(activity, R.raw.karpuz)
        mPlayer?.start()
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fruits_click28, container, false)

        view.imageViewFruitsKarpuz3.setOnClickListener{
            findNavController().navigate(R.id.action_fruitsClick28_to_fruitsSplash24)

        }

        return view
    }
    override fun onDestroy() {

        mPlayer?.stop()

        super.onDestroy()
    }


}