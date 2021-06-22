package com.ebookfrenzy.beaotis.findingobjects.fruits.groupone

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.fragment_click1.view.*

/*
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
*/

class Click1 : Fragment() {
    private var mPlayer: MediaPlayer? = null
    private val nav = R.id.action_click1_to_splashFragment2
    private val item = R.raw.elma
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
        mediaPlay()


        val view= inflater.inflate(R.layout.fragment_click1, container, false)
        view.imageViewFruitsElma.setOnClickListener {
            mPlayer?.stop()
            mPlayer?.release()
            animation(view.imageViewFruitsElma)

        }

        return view
    }


    override fun onDestroy() {
        mPlayer?.release()
        super.onDestroy()
    }

    override fun onDetach() {
        mPlayer?.stop()
        mPlayer?.release()
        super.onDetach()
    }
    fun animation(v:View){
         YoYo.with(Techniques.Pulse )
            .duration(700)
            .repeat(2)
            .playOn(v)
        mPlayer=MediaPlayer.create(activity, R.raw.tebrikler)
        mPlayer?.start()
        mPlayer?.setOnCompletionListener {
            mPlayer?.stop()
            mPlayer?.release()
            mPlayer=null
            findNavController().navigate(nav)
        }
    }

    fun mediaPlay(){
        mPlayer=MediaPlayer.create(activity, item)
        mPlayer?.start()
        mPlayer?.setOnCompletionListener {
            mPlayer?.stop()
            mPlayer?.release()
            mPlayer=null
        }
    }



}