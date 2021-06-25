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
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.SignInDialogFragment
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_parent.*
import kotlinx.android.synthetic.main.app_bar_parent.*

class ParentActivity : AppCompatActivity(),SignInDialogFragment.IGirisYap{
    //, NavigationView.OnNavigationItemSelectedListener
   /* private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle*/
    private lateinit var intentToMainActivity: Intent
    private var user:FirebaseUser?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent)
        user=girisYap(user)
        Log.d("Kullanıcı girdi", "Kullanıcı: $user")
        /*toggle= ActionBarDrawerToggle(this,drawer,toolbar_main,R.string.nav_app_bar_open_drawer_description,R.string.nav_app_bar_navigate_up_description)
        drawer.addDrawerListener(toggle)*/
/*        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        nav_view.setNavigationItemSelectedListener(this)*/

        intentToMainActivity=Intent(this, MainActivity::class.java)
    }
   /* override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_one->Toast.makeText(this, "Clicked item one", Toast.LENGTH_SHORT).show()
            R.id.nav_item_two->Toast.makeText(this, "Clicked item one", Toast.LENGTH_SHORT).show()
            R.id.nav_item_three->Toast.makeText(this, "Clicked item one", Toast.LENGTH_SHORT).show()
            R.id.nav_item_four->Toast.makeText(this, "Clicked item one", Toast.LENGTH_SHORT).show()
            R.id.nav_item_five->Toast.makeText(this, "Clicked item one", Toast.LENGTH_SHORT).show()
            R.id.nav_item_six->Toast.makeText(this, "Clicked item one", Toast.LENGTH_SHORT).show()
            R.id.nav_item_seven->Toast.makeText(this, "Clicked item one", Toast.LENGTH_SHORT).show()
        }
        drawer.closeDrawer(GravityCompat.START)//Tıklanıldığında drawer' ı kapatmak için kullanılır.
        return true
    }
    override fun onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            startActivity(intentToMainActivity)
            super.onBackPressed()
        }
    }*/
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


}