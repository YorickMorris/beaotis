package com.ebookfrenzy.beaotis.findingobjects

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.letsstudy.IOnLetsStudyClickListener

class ObjectMainRecyclerView(private val exampleList: List<FindObjectDataClass>, private val IOnItemClickListener: IOnFindingObjectsClickListener): RecyclerView.Adapter<ObjectMainRecyclerView.RecyclerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ObjectMainRecyclerView.RecyclerViewHolder {
        val itemView= LayoutInflater.from(parent.context).inflate(
            R.layout.activity_finding_objects,
            parent, false
        )
        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ObjectMainRecyclerView.RecyclerViewHolder,
        position: Int
    ) {
        val currentItem = exampleList[position]
        holder.imageView1.setImageResource(currentItem.imageView)
        holder.textView1.text=currentItem.text1
        holder.innercons1.setOnClickListener {
            IOnItemClickListener.onItemClicked(currentItem,position)
        }

    }

    override fun getItemCount(): Int=exampleList.size

    inner class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView1: ImageView = itemView.findViewById(R.id.imgFindObject)
        val textView1: TextView =itemView.findViewById(R.id.txtFinObject)
        val innercons1: ConstraintLayout =itemView.findViewById(R.id.constFindingObjects)
    }

}