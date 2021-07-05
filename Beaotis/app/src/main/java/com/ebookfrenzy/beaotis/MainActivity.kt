package com.ebookfrenzy.beaotis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.educationalsongs.EducationalSongs
import com.ebookfrenzy.beaotis.etiquette.Etiquette
import com.ebookfrenzy.beaotis.findingobjects.FindingObjects
import com.ebookfrenzy.beaotis.letsstudy.LetsStudyActivity
import com.ebookfrenzy.beaotis.pairing.Pairing
import com.ebookfrenzy.beaotis.parent.ParentActivity
import com.ebookfrenzy.beaotis.story.Story
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() , IGeneratorInterface, IOnItemClickListener,SignInDialogFragment.IGirisYap {
    private lateinit var recyclerView: RecyclerView
    private val dialogFragment=SignInDialogFragment()
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateList()

        auth = Firebase.auth

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        //Oluşturduğumuz RecyclerView' in adaptörünü burada çağırıyoruz.
        //generatelist() oluşturacağımız listenin oluşturulduğu fonksiyon
        //IOnItemClickListener ise bu RecyclerView için özelleştirdiğimiz onClick methodu
        val adapter = RecyclerViewAdapter(generateList(), this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()


        //Bu kod ana menüdeki sağ üst kısımda duran ve ebeveyn paneline giriş yapmayı sağlayan
        //arayüzdür. Eğer giriş zaten yapılmışsa giriş yapma ekranı vermeden ebeveyn paneline geçiş
        //sağlanmaktadır.
        toolbar.setNavigationOnClickListener {
            if (FirebaseAuth.getInstance().currentUser!=null){
                // Bu kod ebeveyn modülüne geçmeyi sağlıyor.
                intent = Intent(this, ParentActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                if(savedInstanceState==null){
                    dialogFragment.run { show(supportFragmentManager, "missiles") }
                }
            }
        }
    }

    //ana menüde toolbar simgesi koymak için oluşturulan menü
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }


    //RecyclerView için özelleştirdiğimiz onClick methodunu burada override ederek her bir elemana
    //tıklandığında yapılması gereken işlemler burada tanımlanıyor. Burada yapılan ise her bir
    //elemana tıklandığında bizi farklı bir Activity' e yönlendirmesidir.
    override fun onItemClicked(data: ExampleItem, position: Int, coloumn: Int) {
        when (position) {
            0 -> {
                when (coloumn) {
                    1 -> intent = Intent(this, FindingObjects::class.java)
                    2 -> intent = Intent(this, LetsStudyActivity::class.java)
                    3 -> intent = Intent(this, Pairing::class.java)
                }
            }
            1 -> {
                when (coloumn) {
                    1 -> intent = Intent(this, Story::class.java)
                    2 -> intent = Intent(this, EducationalSongs::class.java)
                    3 -> intent = Intent(this, Etiquette::class.java)
                }
            }

        }
        startActivity(intent)
        finish()
    }

    override fun onResume() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onResume()
    }
    override fun onStart() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onStart()
    }

    //Giriş yapma ara yüzünden almış olduğumuz Firebase kullanıcısı giriş işlemini düzgün bir
    //şekilde yaptıysa MainActivity' e bu kullanıcıyı döndürerek ebeveyn paneline yönlendiriyoruz.
    override fun girisYap(user: FirebaseUser?):FirebaseUser? {
        Log.d("Kullanıcı", "Kullanıcı: $user")
        if (user!=null){
            intent = Intent(this, ParentActivity::class.java)
            startActivity(intent)
            finish()
        }
        return user
    }
}
