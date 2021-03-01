package com.ebookfrenzy.beaotis.aba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import kotlinx.android.synthetic.main.activity_aba.*

class Aba : AppCompatActivity() {
    private lateinit var intentToMainActivity:Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aba)

        intentToMainActivity=Intent(this, MainActivity::class.java)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        left_arrow.setOnClickListener{
            startActivity(intentToMainActivity)
            finish()
        }
        //BackStack kullanımı için fakat bildirimden gelinen sayfa olmalı.
        //Eğer ebeveyn ve çocuk için farklı bildirim ayarlarına sahip olacaksa
        // notification channel group oluştur.
       /* val resultIntent = Intent(this, Aba::class.java)
        val resultPendingIntent: PendingIntent? = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(resultIntent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }*/

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