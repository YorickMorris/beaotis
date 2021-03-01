package com.ebookfrenzy.beaotis.markyourheard

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.ebookfrenzy.beaotis.IFireStoreList
import com.ebookfrenzy.beaotis.MainActivity
import com.ebookfrenzy.beaotis.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_mark_your_heard.*

class MarkYourHeard : AppCompatActivity(),IFireStoreList,IGenerator,IOnImageViewClick {
    private lateinit var viewPager: ViewPager2
    //val alovelaceDocumentRef = db.collection("users").document("alovelace")
    // or val alovelaceDocumentRef = db.document("users/alovelace")
    var column:Int?=null
    private val db = Firebase.firestore
    private val groupOne =db.document("animal_voices/level_one").get()
    private val groupTwo =db.document("animal_voices/level_two").get()
    private val groupThree =db.document("animal_voices/level_three").get()
    private val groupFour =db.document("animal_voices/level_four").get()
    private val groupFive =db.document("animal_voices/level_five").get()
    private val groupSix =db.document("animal_voices/level_six").get()
    private val groupSeven =db.document("animal_voices/level_seven").get()
    private val groupEight =db.document("animal_voices/level_eight").get()
    private val groupNine =db.document("animal_voices/level_nine").get()
    private val groupTen =db.document("animal_voices/level_ten").get()
    private var list:MutableList<String>?= FireStoreListOne()
    private var images:MutableList<MutableList<String>?>?=mutableListOf()

    private lateinit var intentToMainActivity:Intent
    private var mutableList:MutableList<String>?=mutableListOf()
    private val tag="className"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mark_your_heard)
        Log.d(tag,"onCreate çağrıldı.")
        fireStoreLinkleriniAl()
        println("Firestore linkleri= ${fireStoreLinkleriniAl()}")
        println("list çıktısı= $list")

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        intentToMainActivity=Intent(this, MainActivity::class.java)

        viewPager=findViewById(R.id.viewPager)
        val pageAdapter=ViewPagerAdapter(generateImageGroups(),this,this,fireStoreLinkleriniAl())
        viewPager.adapter=pageAdapter
        left_arrow9.setOnClickListener{
            val intent= Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    //mViewPager.setCurrentItem(2) -> Bu view pager ile butona basıldığında diğer sayfaya geçmemizi sağlar.

    override fun onImageViewClicked(clickable: ViewPage, position: Int, column: Int) {
       /* when(position){
            0->{
                when(column){
                    1->viewPager.currentItem = 2
                    2->viewPager.currentItem = 2
                    3->viewPager.currentItem = 2
                }
            }
            1->{
                when(column){
                1->
                2->
                3->
            }

            }
            2->{
                when(column){
                    1->
                    2->
                    3->
                }

            }
            3->{
                when(column){
                    1->
                        2->
                    3->
                }

            }
            4->{
                when(column){
                    1->
                        2->
                    3->
                }

            }
            5->{
                when(column){
                    1->
                        2->
                    3->
                }

            }
            6->{
                when(column){
                    1->
                        2->
                    3->
                }

            }
            7->{
                when(column){
                    1->
                        2->
                    3->
                }

            }
            8->{
                when(column){
                    1->
                        2->
                    3->
                }

            }
            9->{
                when(column){
                    1->
                        2->
                    3->
                }

            }
            10->{
                when(column){
                    1->
                        2->
                    3->
                }

            }
            2->{
                when(column){
                    1->
                        2->
                    3->
                }

            }
            2->{
                when(column){
                    1->
                        2->
                    3->
                }

            }
            2->{
                when(column){
                    1->
                        2->
                    3->
                }

            }
        }*/
    }

    private fun fireStoreLinkleriniAl():MutableList<MutableList<String>?>?{
        /* readData(object : MyCallback() {
           fun onCallback(settings: UserAccountSettings) {
               Log.d("TAG", settings.getDisplay_name())
           }
       })*/
        val a=object:IAsyncFireHandler{
            override fun onCallBack(liste:MutableList<String>?){
                Log.d("TAG", " Liste onCreate= $liste")
                images?.add(liste)
            }
        }
        println("a =$a")
        object:IAsyncFireHandler{
            override fun onCallBack(liste:MutableList<String>?){
                Log.d("TAG", " Liste onCreate= ${liste.toString()}")
                images?.add(liste)
            }
        }



        val b=object:IAsyncFireHandler{
            override fun onCallBack(liste:MutableList<String>?){
                Log.d("TAG", " Liste onCreate= $liste")
                images?.add(liste)
            }

        }
        val c=object:IAsyncFireHandler{
            override fun onCallBack(liste:MutableList<String>?){
                Log.d("TAG", " Liste onCreate= $liste")
                images?.add(liste)
            }
        }
        val d=object:IAsyncFireHandler{
            override fun onCallBack(liste:MutableList<String>?){
                Log.d("TAG", " Liste onCreate= $liste")
                images?.add(liste)
            }
        }
        val e=object:IAsyncFireHandler{
            override fun onCallBack(liste:MutableList<String>?){
                Log.d("TAG", " Liste onCreate= $liste")
                images?.add(liste)
            }
        }
        val f=object:IAsyncFireHandler{
            override fun onCallBack(liste:MutableList<String>?){
                Log.d("TAG", " Liste onCreate= $liste")
                images?.add(liste)
            }
        }
        val g=object:IAsyncFireHandler{
            override fun onCallBack(liste:MutableList<String>?){
                Log.d("TAG", " Liste onCreate= $liste")
                images?.add(liste)
            }
        }
        val h=object:IAsyncFireHandler{
            override fun onCallBack(liste:MutableList<String>?){
                Log.d("TAG", " Liste onCreate= $liste")
                images?.add(liste)
            }
        }
        val i=object:IAsyncFireHandler{
            override fun onCallBack(liste:MutableList<String>?){
                Log.d("TAG", " Liste onCreate= $liste")
                images?.add(liste)
            }
        }

        getFirestoreList(groupTwo,"second",b)
        getFirestoreList(groupThree,"third",c)
        getFirestoreList(groupFour,"fourth",d)
        getFirestoreList(groupFive,"fifth",e)
        getFirestoreList(groupSeven,"seventh",f)
        getFirestoreList(groupEight,"eighth",g)
        getFirestoreList(groupNine,"ninth",h)
        getFirestoreList(groupTen,"tenth",i)

        images?.shuffle()
        Log.d(ContentValues.TAG, "images:$images")
        return images
    }

    override fun onBackPressed() {
        startActivity(intentToMainActivity)
        super.onBackPressed()
    }

    override fun onCallBack(liste: MutableList<String>?) {
        Log.d("TAG", " Liste onCreate= $liste")
    }

    fun FireStoreListOne():MutableList<String>?{
        groupOne.addOnSuccessListener {
            if (it!=null){
                list=it.get("first") as MutableList<String>?
            }else
                Log.d("TAG","Ne yazık ki liste dönmedi.")
        }
        return list
    }

    override fun onResume() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        super.onResume()
    }

}