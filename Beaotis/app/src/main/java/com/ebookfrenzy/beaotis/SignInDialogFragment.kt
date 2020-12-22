package com.ebookfrenzy.beaotis

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.sign_in.view.*
import java.lang.IllegalStateException

class SignInDialogFragment: DialogFragment() {
    private lateinit var auth: FirebaseAuth
    private val tag1:String="className"
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        Log.d(tag,"Tıklandı. 1")
        val intent=Intent(activity,SignUpActivity::class.java)
        auth = Firebase.auth
        return activity?.let {
            val builder= AlertDialog.Builder(requireContext(),R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
            val inflater=requireActivity().layoutInflater
            val view = inflater.inflate(R.layout.sign_in,null)
            builder.setView(view)
               .setPositiveButton(R.string.signIn) { dialog, id ->
                   auth.signInWithEmailAndPassword(
                       view.eposta.text.toString(),
                       view.sifreGir.text.toString()
                   )
                       .addOnCompleteListener { task ->
                           if (task.isSuccessful) {
                               Log.d(tag1, "signInWithEmail:success")
                               val user = auth.currentUser
                              updateUI(user,view)
                           } else {
                               updateUI(null,view)
                           }
                       }
                   dismiss()
                   //Giriş eylemleri
               }
                .setNeutralButton(R.string.sign_up) { dialog, which ->
                    startActivity(intent)
                    //Kayıt ol sayfaseına göndersin
                    dialog.dismiss()
                    Log.d(tag1,"Kayıt ol' a geçti")
                }
                .setNegativeButton(R.string.cancel) { dialog, id ->
                    //İptal et
                    dialog.cancel()
                    Log.d(tag1,"Dialog dismissed!")
                }
            builder.create()
        }?:throw IllegalStateException("Aktivite boş olamaz.")

    }
    private fun updateUI(user: FirebaseUser?,view:View){
        if(user!=null){
            Toast.makeText(view.context,"Giriş işlemi tamamlandı.",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(view.context,"Giriş işlemi tamamlanamadı.",Toast.LENGTH_LONG).show()
        }
    }

}