package com.ebookfrenzy.beaotis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(private val exampleList:List<ExampleItem>): RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {

        val itemView= LayoutInflater.from(parent.context).inflate(R.layout.deneme,
        parent, false)
        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.imageView1.setImageResource(currentItem.imageResource1)
        holder.imageView2.setImageResource(currentItem.imageResource2)
        holder.imageView3.setImageResource(currentItem.imageResource3)
        holder.textView1.text=currentItem.text1
        holder.textView2.text=currentItem.text2
        holder.textView3.text=currentItem.text3
        holder.itemView.setOnClickListener(){} //TODO Her bir Recycler Öğesine bir clicklistener eklemem gerekiyor.
    }

    override fun getItemCount() = exampleList.size

    class RecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView1: ImageView = itemView.findViewById(R.id.img1)
        val textView1: TextView=itemView.findViewById(R.id.txt1)

        val imageView2: ImageView = itemView.findViewById(R.id.img2)
        val textView2: TextView=itemView.findViewById(R.id.txt2)

        val imageView3: ImageView = itemView.findViewById(R.id.img3)
        val textView3: TextView=itemView.findViewById(R.id.txt3)
    }

}