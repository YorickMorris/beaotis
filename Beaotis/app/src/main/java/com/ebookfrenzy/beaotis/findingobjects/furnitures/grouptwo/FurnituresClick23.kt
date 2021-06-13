package com.ebookfrenzy.beaotis.findingobjects.furnitures.grouptwo

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.fragment_click3.view.*
import kotlinx.android.synthetic.main.fragment_furnitures_click23.view.*


class FurnituresClick23 : Fragment() {

    private var mPlayer: MediaPlayer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mPlayer=MediaPlayer.create(activity, R.raw.pantolon)
        mPlayer?.start()

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_furnitures_click23, container, false)

        view.imageViewFurnituresPantalon1.setOnClickListener{
            findNavController().navigate(R.id.action_furnituresClick23_to_furnituresClick24)
        }

        return view
    }
    override fun onDestroy() {

        mPlayer?.stop()

        super.onDestroy()
    }


}