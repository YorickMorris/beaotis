package com.ebookfrenzy.beaotis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.sign_in.*

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private val TAG="ClassName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        auth = Firebase.auth
        onItemClick(submitButton)

    }
     private fun onItemClick(view: View){
        view.setOnClickListener {
            auth.createUserWithEmailAndPassword(email.text.toString(), sifre.text.toString())
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d(TAG,"${sifre.text.toString()}")
                        val user = auth.currentUser
                        updateUI(user)
                    } else {
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        updateUI(null)
                    }
                }
        }
    }
    private fun updateUI(user:FirebaseUser?){
        if(user!=null){
            Toast.makeText(this,"Üyelik işlemi tamamlandı.",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Üyelik işlemi tamamlanamadı.",Toast.LENGTH_LONG).show()
        }

    }
}