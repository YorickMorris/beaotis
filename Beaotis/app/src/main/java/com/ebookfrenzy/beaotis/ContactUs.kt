package com.ebookfrenzy.beaotis

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.contact_us.*
import java.lang.Exception

class ContactUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_us)

        val context = this
        left_arrow12.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        submitButton.setOnClickListener{
            val eMail = editText1.text.toString().trim()
            val subject = editText2.text.toString().trim()
            val message = editText3.text.toString().trim()

            sendEmail(eMail,subject,message)

        }
    }

    private fun sendEmail(eMail: String, subject: String, message: String) {
        val mIntent=Intent(Intent.ACTION_SEND)

        mIntent.data= Uri.parse("mailto:")
        mIntent.type=  "text/plain"

        mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(eMail))
        mIntent.putExtra(Intent.EXTRA_SUBJECT,subject )
        mIntent.putExtra(Intent.EXTRA_TEXT,message)

        try {
                startActivity(Intent.createChooser(mIntent,"Gmail' i seçiniz"))
        }catch (e:Exception){
                Toast.makeText(this,"Mesaj Yollanıyor...",Toast.LENGTH_LONG).show()
        }
    }
}