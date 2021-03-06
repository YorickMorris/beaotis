package com.ebookfrenzy.beaotis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val exampleList: List<ExampleItem>, private val IOnItemClickListener: IOnItemClickListener): RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>(){

    //MainActivity ana menüsü için özel olarak oluşturulmuş RecyclerView.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        //Her bir RecyclerView elemanının referans alındığı layout dosyası.
        val itemView= LayoutInflater.from(parent.context).inflate(
            R.layout.deneme,
            parent, false
        )
        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        //RecyclerView kullanılacağı aktiviteye bağlandığında yapılması gerekenler.
        val currentItem = exampleList[position]
        holder.imageView1.setImageResource(currentItem.imageResource1)
        holder.imageView2.setImageResource(currentItem.imageResource2)
        holder.imageView3.setImageResource(currentItem.imageResource3)
        holder.textView1.text=currentItem.text1
        holder.textView2.text=currentItem.text2
        holder.textView3.text=currentItem.text3
        holder.innercons1.setOnClickListener{
            IOnItemClickListener.onItemClicked(currentItem,position,1)
        }
        holder.innercons2.setOnClickListener {
            IOnItemClickListener.onItemClicked(currentItem,position,2)
        }
        holder.innercons3.setOnClickListener{
            IOnItemClickListener.onItemClicked(currentItem,position,3)
        }
    }

    //Tüm elemanların sayısını döndüren fonksiyon
    override fun getItemCount() = exampleList.size

   inner class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       //Her bir RecyclerView elemanının referans alındığı layout dosyasındaki tüm layout elemanları.
        val imageView1: ImageView = itemView.findViewById(R.id.img1)
        val textView1: TextView=itemView.findViewById(R.id.txt1)

        val imageView2: ImageView = itemView.findViewById(R.id.img2)
        val textView2: TextView=itemView.findViewById(R.id.txt2)

        val imageView3: ImageView = itemView.findViewById(R.id.img3)
        val textView3: TextView=itemView.findViewById(R.id.txt3)

        val innercons1: ConstraintLayout=itemView.findViewById(R.id.innercons1)
        val innercons2: ConstraintLayout=itemView.findViewById(R.id.innercons2)
        val innercons3: ConstraintLayout=itemView.findViewById(R.id.innercons3)

    }
}