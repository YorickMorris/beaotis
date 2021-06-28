package com.ebookfrenzy.beaotis.parent

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.RecyclerViewAdapter
import com.ebookfrenzy.beaotis.SignInDialogFragment
import com.ebookfrenzy.beaotis.findingobjects.FindObjectDataClass
import com.ebookfrenzy.beaotis.findingobjects.IOnFindingObjectsClickListener
import com.ebookfrenzy.beaotis.findingobjects.ObjectMainRecyclerView
import com.ebookfrenzy.beaotis.letsstudy.LetsStudyActivity
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_parent.*
import kotlinx.android.synthetic.main.app_bar_parent.*

class ParentActivity : AppCompatActivity(),SignInDialogFragment.IGirisYap,IOnFindingObjectsClickListener,IParentActivityGenerator{
    private lateinit var intentToMainActivity: Intent
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)

        Log.d("Kullanıcı girdi", "Kullanıcı: ${FirebaseAuth.getInstance().currentUser}")

        intentToMainActivity=Intent(this, MainActivity::class.java)

        recyclerView = findViewById(R.id.recyclerViewParent)
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val adapter = ObjectMainRecyclerView(paren_generatorList(), this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        left_arrow.setOnClickListener {
            startActivity(intentToMainActivity)
            finish()
        }

    }

   override fun onBackPressed() {
       startActivity(intentToMainActivity)
       finish()
       super.onBackPressed()
   }

    fun clickLogOut(view: View) {
        if (FirebaseAuth.getInstance().currentUser!=null){
            Firebase.auth.signOut()
            startActivity(intentToMainActivity)
            finish()
        }else{
            Toast.makeText(this,"Kullanıcı bulunamadı!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun girisYap(user: FirebaseUser?):FirebaseUser? {
        return user
    }

    override fun onItemClicked(data: FindObjectDataClass, position: Int) {
        when(position){
            0->intent = Intent(this, SonucFruitsActivity::class.java)
            1->intent = Intent(this, SonucVegetablesActivity::class.java)
            2->intent = Intent(this, SonucVehiclesActivity::class.java)
            3->intent = Intent(this, SonucFurnituresActivity::class.java)
        }
        startActivity(intent)
        finish()
    }
}