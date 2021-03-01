package com.ebookfrenzy.beaotis.markyourheard

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ebookfrenzy.beaotis.IFireStoreList
import com.ebookfrenzy.beaotis.R
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.delay


class ViewPagerAdapter(private val viewPagerList:List<ViewPage>,
                       private val IOnImageViewClick: IOnImageViewClick,
                       private val context:Context,
                       private val images:MutableList<MutableList<String>?>?):RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>(),IFireStoreList {
    private var list:MutableList<Int>?= mutableListOf()
    //private var images:MutableList<MutableList<String>?>?=mutableListOf()
    private var imagesList:MutableList<String>?=mutableListOf()
    private val db = Firebase.firestore
    //Herhangi bir eylem sonucu oluştuğu için bunları main sınıfıma almalıyım.
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
    private val tag="className"

    inner class ViewPagerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        var imageView1: ImageView = itemView.findViewById(R.id.image1)
        var imageView2: ImageView = itemView.findViewById(R.id.image2)
        var imageView3: ImageView = itemView.findViewById(R.id.image3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        Log.d(tag,"OnCreateViewHolder çağrıldı.")
        val itemView= LayoutInflater.from(parent.context).inflate(
            R.layout.viewpager_sample,
            parent, false
        )
        return ViewPagerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        Log.d(tag,"onBindViewHolder çağrıldı.")
       /* val six= object:IAsyncFireHandler{
            override fun onCallBack(liste: MutableList<String>?):MutableList<String>?{
                return liste
            }
        }*/

       /* images?.add(0,getFirestoreListSon(groupOne,"first",db,six))
        images?.add(1,getFirestoreListSon(groupTwo,"second",db,six))
        images?.add(2,getFirestoreListSon(groupThree,"third",db,six))
        images?.add(3,getFirestoreListSon(groupFour,"fourth",db,six))
        images?.add(4,getFirestoreListSon(groupFive,"fifth",db,six))
        images?.add(5,getFirestoreListSon(groupSix,"sixth",db,six))
        images?.add(6,getFirestoreListSon(groupSeven,"seventh",db,six))
        images?.add(7,getFirestoreListSon(groupEight,"eighth",db,six))
        images?.add(8,getFirestoreListSon(groupNine,"ninth",db,six))
        images?.add(9,getFirestoreListSon(groupTen,"tenth",db,six))
        images?.shuffle()
        Log.d(TAG, "images:$images")*/

        val currentItem=viewPagerList[position]
        val temporaryList:MutableList<String>?
        holder.imageView1.setImageResource(currentItem.x)
        holder.imageView2.setImageResource(currentItem.y)
        holder.imageView3.setImageResource(currentItem.z)
        when(position){
            0->{
                temporaryList= images?.get(0)
                val x= temporaryList?.get(0)
                checkForTrueOne(x)
                Glide.with(context).load(temporaryList?.get(1)).into(holder.imageView1)
                Glide.with(context).load(temporaryList?.get(2)).into(holder.imageView2)
                Glide.with(context).load(temporaryList?.get(3)).into(holder.imageView3)
            }
            1->{
                temporaryList= images?.get(1)
                val x= temporaryList?.get(1)
                checkForTrueOne(x)
                Glide.with(context).load(temporaryList?.get(1)).into(holder.imageView1)
                Glide.with(context).load(temporaryList?.get(2)).into(holder.imageView2)
                Glide.with(context).load(temporaryList?.get(3)).into(holder.imageView3)
            }
            2->{
                temporaryList= images?.get(2)
                val x= temporaryList?.get(2)
                checkForTrueOne(x)
                Glide.with(context).load(temporaryList?.get(1)).into(holder.imageView1)
                Glide.with(context).load(temporaryList?.get(2)).into(holder.imageView2)
                Glide.with(context).load(temporaryList?.get(3)).into(holder.imageView3)
            }
            3->{
                temporaryList= images?.get(3)
                val x= temporaryList?.get(3)
                checkForTrueOne(x)
                Glide.with(context).load(temporaryList?.get(1)).into(holder.imageView1)
                Glide.with(context).load(temporaryList?.get(2)).into(holder.imageView2)
                Glide.with(context).load(temporaryList?.get(3)).into(holder.imageView3)
            }
            4->{
                temporaryList= images?.get(4)
                val x= temporaryList?.get(4)
                checkForTrueOne(x)
                Glide.with(context).load(temporaryList?.get(1)).into(holder.imageView1)
                Glide.with(context).load(temporaryList?.get(2)).into(holder.imageView2)
                Glide.with(context).load(temporaryList?.get(3)).into(holder.imageView3)
            }
            5->{
                temporaryList= images?.get(5)
                val x= temporaryList?.get(5)
                checkForTrueOne(x)
                Glide.with(context).load(temporaryList?.get(1)).into(holder.imageView1)
                Glide.with(context).load(temporaryList?.get(2)).into(holder.imageView2)
                Glide.with(context).load(temporaryList?.get(3)).into(holder.imageView3)
            }
            6->{
                temporaryList= images?.get(6)
                val x= temporaryList?.get(6)
                checkForTrueOne(x)
                Glide.with(context).load(temporaryList?.get(1)).into(holder.imageView1)
                Glide.with(context).load(temporaryList?.get(2)).into(holder.imageView2)
                Glide.with(context).load(temporaryList?.get(3)).into(holder.imageView3)
            }
            7->{
                temporaryList= images?.get(7)
                val x= temporaryList?.get(7)
                checkForTrueOne(x)
                Glide.with(context).load(temporaryList?.get(1)).into(holder.imageView1)
                Glide.with(context).load(temporaryList?.get(2)).into(holder.imageView2)
                Glide.with(context).load(temporaryList?.get(3)).into(holder.imageView3)
            }
            8->{
                temporaryList= images?.get(8)
                val x= temporaryList?.get(8)
                checkForTrueOne(x)
                Glide.with(context).load(temporaryList?.get(1)).into(holder.imageView1)
                Glide.with(context).load(temporaryList?.get(2)).into(holder.imageView2)
                Glide.with(context).load(temporaryList?.get(3)).into(holder.imageView3)
            }
            9->{
                temporaryList= images?.get(9)
                val x= temporaryList?.get(9)
                checkForTrueOne(x)
                Glide.with(context).load(temporaryList?.get(1)).into(holder.imageView1)
                Glide.with(context).load(temporaryList?.get(2)).into(holder.imageView2)
                Glide.with(context).load(temporaryList?.get(3)).into(holder.imageView3)
            }
        }

        holder.imageView1.setOnClickListener {
            IOnImageViewClick.onImageViewClicked(currentItem,position,1)

        }
        holder.imageView2.setOnClickListener {
            IOnImageViewClick.onImageViewClicked(currentItem,position,2)
        }
        holder.imageView3.setOnClickListener {
            IOnImageViewClick.onImageViewClicked(currentItem,position,3)
        }
    }

    override fun getItemCount(): Int=viewPagerList.size

    private fun checkForTrueOne(value: String?): MutableList<Int>? {
        when(value){
            "1"-> list?.add(1)
            "2"-> list?.add(2)
            "3"-> list?.add(3)
        }
        return list
    }

    override fun onCallBack(liste: MutableList<String>?){
    }
}