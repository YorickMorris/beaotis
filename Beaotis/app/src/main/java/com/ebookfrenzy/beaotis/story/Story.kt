package com.ebookfrenzy.beaotis.story

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_story.*

class Story : YouTubeBaseActivity(),YouTubePlayer.OnInitializedListener,YouTubePlayer.PlayerStateChangeListener {
    //Projeye özel olarak alınmış youtube api anahtarı.
    private val youtubeApiKey:String="AIzaSyAznR4fg2HUaTf9BlLzDvSnEYVcRWb5Rpo"
    private val recoveryRequest = 1
    private lateinit var intentToMainActivity:Intent
    //Youtube api sinin çekildiği aktivite.
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_story)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        intentToMainActivity=Intent(this, MainActivity::class.java)

        youtubeView.initialize(youtubeApiKey, this)

        left_arrow11.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
    }

    override fun onInitializationSuccess(
        p0: YouTubePlayer.Provider?,
        p1: YouTubePlayer?,
        p2: Boolean
    ) {
        //Oynatılacak videonun adresi
        if (!p2) {
            p1?.cueVideo("N4F8x0iR0nk")
            //İnternet Adresi:https://www.youtube.com/watch?v=N4F8x0iR0nk&t=9s&ab_channel=AdisebabaMasal
        }
    }

    //Eğer api anahtarı ile bağlanma başarısız olursa.
    override fun onInitializationFailure(
        p0: YouTubePlayer.Provider?,
        p1: YouTubeInitializationResult?
    ) {
        if (p1?.isUserRecoverableError == true) {
            p1.getErrorDialog(this, recoveryRequest).show()
        } else {
            Toast.makeText(this, "Sistemde teknik bir sorun yaşanmaktadır.", Toast.LENGTH_LONG).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == recoveryRequest) {
            youtubeView.initialize(youtubeApiKey, this)
        }
    }

    override fun onLoading() {
        //
    }

    override fun onLoaded(p0: String?) {
        //
    }

    override fun onAdStarted() {
        //
    }

    override fun onVideoStarted() {
     //
    }

    override fun onVideoEnded(){
        Toast.makeText(this, "Tebrikler tüm videoyu izledin!", Toast.LENGTH_LONG).show()
    }

    override fun onError(p0: YouTubePlayer.ErrorReason?) {
       //
    }
    override fun onBackPressed() {
        startActivity(intentToMainActivity)
        super.onBackPressed()
    }
    override fun onResume() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onResume()
    }
}