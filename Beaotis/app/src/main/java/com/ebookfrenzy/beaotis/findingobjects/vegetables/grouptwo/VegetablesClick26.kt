package com.ebookfrenzy.beaotis.findingobjects.vegetables.grouptwo

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.fragment_furnitures_click26.view.*
import kotlinx.android.synthetic.main.fragment_vegetables_click26.view.*


class VegetablesClick26 : Fragment() {

    private var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mPlayer=MediaPlayer.create(activity, R.raw.biber)
        mPlayer?.start()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_vegetables_click26, container, false)

        view.imageViewVegetablesBiber3.setOnClickListener {
            findNavController().navigate(R.id.action_vegetablesClick26_to_vegetablesClick27)
        }

        return view
    }
    override fun onDestroy() {

        mPlayer?.stop()

        super.onDestroy()
    }


}