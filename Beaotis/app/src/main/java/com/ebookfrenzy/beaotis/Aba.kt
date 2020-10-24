package com.ebookfrenzy.beaotis

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.TaskStackBuilder
import kotlinx.android.synthetic.main.activity_aba.*

class Aba : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aba)

        left_arrow.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
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
}