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

class Click3 : Fragment() {

    private var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mPlayer=MediaPlayer.create(activity, R.raw.elma)
        mPlayer?.start()

        val view= inflater.inflate(R.layout.fragment_click3, container, false)
        view.imageViewFruitsElma.setOnClickListener {
            findNavController().navigate(R.id.action_click3_to_click4)
        }
        return view
    }
    override fun onDestroy() {

        mPlayer?.stop()

        super.onDestroy()
    }
}