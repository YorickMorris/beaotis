package com.ebookfrenzy.beaotis.findingobjects.fruits.groupone

import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.android.synthetic.main.fragment_splash4.*
import kotlinx.android.synthetic.main.fragment_splash4.view.*

//RequestListener<Drawable>
class SplashFragment4 : Fragment(){

    val requestOption= RequestOptions().placeholder(R.drawable.e).centerCrop()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_splash4, container, false)

      /*  view.elmaTextView5.setOnClickListener {
            Glide.with(view.context).asGif().load(R.raw.giphy).into(imageTebrikler)
        }*/
        Handler().postDelayed({

            findNavController().navigate(R.id.action_splashFragment4_to_fruitsActivity)


        }, 3000)


        /*val videoPath="android.resource://${view.context.packageName}/raw/clap"
        clap_video.setVideoPath(videoPath)
        clap_video.setOnCompletionListener{
            val r= Runnable {
                findNavController().navigate(R.id.action_splashFragment4_to_fruitsActivity)
            }
            Handler().postDelayed(r,500)
        }
        video_view.start()*/


        return view
    }

   /* override fun onLoadFailed(
        e: GlideException?,
        model: Any?,
        target: Target<Drawable>?,
        isFirstResource: Boolean
    ): Boolean {
        return false
    }*/

   /* override fun onResourceReady(
        resource: Drawable?,
        model: Any?,
        target: Target<Drawable>?,
        dataSource: DataSource?,
        isFirstResource: Boolean
    ): Boolean {
        return false
    }*/
    /* override fun onDestroy() {
       clap_video.stopPlayback()
         super.onDestroy()
     }*/

}