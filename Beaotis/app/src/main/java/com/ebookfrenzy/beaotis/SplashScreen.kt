package com.ebookfrenzy.beaotis

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*
import java.lang.Exception

class SplashScreen : AppCompatActivity(){
    private lateinit var intentToMainActivity:Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        try{
            val videoPath="android.resource://$packageName/raw/p720"
            video_view.setVideoPath(videoPath)
            Log.d("Video Url", videoPath)
            video_view.setOnCompletionListener{
                val r= Runnable {
                    startActivity(Intent(this@SplashScreen,MainActivity::class.java))
                    finish()
                }
                Handler().postDelayed(r,500)
            }
            video_view.start()
        }catch (ex:Exception){
            jump()
        }

    }
    private fun jump(){
        if(isFinishing)
            return
        intentToMainActivity=Intent(this, MainActivity::class.java)
        startActivity(intentToMainActivity)
        finish()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        jump()
        return true
    }

    override fun onStart() {
        // Status barı saklamak için. Mümkünse programatik yapıp xml ile ayarla.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onStart()
    }

}