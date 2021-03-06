package com.ebookfrenzy.beaotis.letsstudy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R

class LetsStudyRecyclerView(private val ogeList: List<LetsStudyExampleItem>, private val IOnItemClickListener: IOnLetsStudyClickListener):
    RecyclerView.Adapter<LetsStudyRecyclerView.RecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LetsStudyRecyclerView.RecyclerViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(
            R.layout.letsstudy_recyclerview_sample,
            parent, false
        )
        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LetsStudyRecyclerView.RecyclerViewHolder, position: Int) {
        val currentItem = ogeList[position]
        holder.image.setImageResource(currentItem.imageView)
        holder.image.setOnClickListener {
            IOnItemClickListener.onItemClicked(currentItem,position,holder.image)
        }
    }

    override fun getItemCount() = ogeList.size

    inner class RecyclerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val image:ImageView=itemView.findViewById(R.id.imageLetsStudy)
    }
}