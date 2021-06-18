package com.ebookfrenzy.beaotis.findingobjects

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R

class SubRecyclerView(private val exampleList: List<SubObjectDataClass>, private val IOnItemClickListener: SubObjectsClickListener): RecyclerView.Adapter<SubRecyclerView.RecyclerViewHolder>(){

    inner class RecyclerViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imageView1: ImageView = itemView.findViewById(R.id.subFindObject)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubRecyclerView.RecyclerViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(
            R.layout.object_sample,
            parent, false )
        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SubRecyclerView.RecyclerViewHolder, position: Int) {
        val currentItem = exampleList[position]
        holder.imageView1.setImageResource(currentItem.imageResource1)
        holder.imageView1.setOnClickListener{
            IOnItemClickListener.onItemClicked(currentItem,position)
        }
    }

    override fun getItemCount()=exampleList.size
}