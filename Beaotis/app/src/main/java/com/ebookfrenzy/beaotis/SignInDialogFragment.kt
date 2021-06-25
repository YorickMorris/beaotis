package com.ebookfrenzy.beaotis

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.ebookfrenzy.beaotis.parent.ParentActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.sign_in.*
import kotlinx.android.synthetic.main.sign_in.view.*
import java.lang.IllegalStateException

class SignInDialogFragment: DialogFragment() {
    private lateinit var auth: FirebaseAuth
    private val tag1:String="className"

    interface IGirisYap{
        fun girisYap(user:FirebaseUser?):FirebaseUser?
    }
    var giris:IGirisYap?=null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var user:FirebaseUser?=null
        Log.d(tag,"Tıklandı. 1")
        val intent=Intent(activity,SignUpActivity::class.java)
        auth = Firebase.auth
        val inflater=requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.sign_in,null)
        val intent1=Intent(activity,ParentActivity::class.java)
        return activity?.let {
            val builder= AlertDialog.Builder(requireContext(),R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
            builder.setView(view)
               .setPositiveButton(R.string.signIn) { dialog, _ ->
                  val a=view.eposta.text.toString()
                   val b=view.sifreGir.text.toString()
                   if(a!="" && b!="")
                   {
                       auth.signInWithEmailAndPassword(a,b)
                           .addOnCompleteListener { task ->

                               if (task.isSuccessful) {
                                   correctUser(task.isSuccessful)
                                   Log.d(tag1, "signInWithEmail:success")
                                   user = auth.currentUser
                                    if(isAdded){
                                        updateUI(user,view,intent)
                                    }
                                   Log.d(tag1,"Eposta:$a,Şifre:$b")
                                   dialog.dismiss()
                                   Toast.makeText(view.context,"Giriş yapıldı.",Toast.LENGTH_SHORT).show()
                                   if (user!=null){
                                       Log.d(tag1, "$user")
                                       giris?.girisYap(user)
                                   }

                                   //updateUI(user,view,intent1)
                               }

                           }.addOnFailureListener {
                               updateUI(user,view,intent1)
                           }


                   }else if(a=="" && b!=""){
                       Toast.makeText(view.context,"Lütfen Eposta Adresinizi Girin",Toast.LENGTH_SHORT).show()
                   }else if(a!="" && b==""){
                       Toast.makeText(view.context,"Lütfen Şifrenizi Girin",Toast.LENGTH_SHORT).show()
                   }else{
                       Toast.makeText(view.context,"Lütfen Eposta ve Şifre' yi boş bırakmayın.",Toast.LENGTH_SHORT).show()
                   }

                   dialog.dismiss()

                   //Giriş eylemleri
               }
                .setNeutralButton(R.string.sign_up) { dialog, _ ->
                    startActivity(intent)
                    //Kayıt ol sayfasına göndersin
                    dialog.dismiss()
                    Log.d(tag1,"Kayıt ol' a geçti")
                }
                .setNegativeButton(R.string.cancel) { dialog, _ ->
                    //İptal et
                    dialog.cancel()
                    dialog.dismiss()
                    Log.d(tag1,"Dialog dismissed!")
                }
            builder.create()
        }?:throw IllegalStateException("Aktivite boş olamaz.")

    }
    private fun updateUI(user: FirebaseUser?,view:View,intent:Intent){
        if(user!=null){
            startActivity(intent)
        }else{
            Toast.makeText(view.context,"Giriş yapılamadı.",Toast.LENGTH_SHORT).show()
        }
    }
    private fun correctUser(isSuccessful:Boolean):Boolean{
        return isSuccessful
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            giris = activity as IGirisYap?
        }catch (e:ClassCastException){
            Log.d("TAG","onAttach: ${e.message}")
        }

    }
}