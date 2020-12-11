package com.ebookfrenzy.beaotis

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.lang.IllegalStateException

class SignInDialogFragment: DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //return super.onCreateDialog(savedInstanceState)
        return activity?.let {
            val builder= AlertDialog.Builder(it,R.style.MyThemeOverlay_MaterialComponents_MaterialAlertDialog)
            val inflater=requireActivity().layoutInflater
            builder.setView(inflater.inflate(R.layout.sign_in,null))
               .setPositiveButton(R.string.signIn, DialogInterface.OnClickListener { dialog, id ->
                    //Giriş eylemleri
                    dialog.dismiss()
                })
                .setNeutralButton(R.string.sign_up,DialogInterface.OnClickListener { dialog, which ->

                    //Kayıt ol sayfaseına göndersin
                    dialog.dismiss()
                })
                .setNegativeButton(R.string.cancel,DialogInterface.OnClickListener { dialog, id ->

                    dialog?.cancel()
                })


            builder.create()

        }?:throw IllegalStateException("Aktivite boş olamaz.")
    }
}