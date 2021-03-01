package com.ebookfrenzy.beaotis.completesentence

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.ebookfrenzy.beaotis.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class ViewPagerAdapterF(private val list: MutableList<CompleteSentenceSampleData>,
                        private val IOnAnswerClick:IOnAnswerClick,
                        private val context: Context
                        ): RecyclerView.Adapter<ViewPagerAdapterF.ViewPagerViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerViewHolder {
        val itemView=LayoutInflater.from(parent.context).inflate(R.layout.complete_sentence_sample,
            parent, false)
        return ViewPagerViewHolder(itemView)
    }

    inner class ViewPagerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val button1:MaterialButton=itemView.findViewById(R.id.secenek1)
        val button2:MaterialButton=itemView.findViewById(R.id.secenek2)
        val button3:MaterialButton=itemView.findViewById(R.id.secenek3)

        val editText:TextInputEditText=itemView.findViewById(R.id.inputEditText)

        val textInput:TextInputLayout=itemView.findViewById(R.id.textTamamla)

    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.button1.setText(R.string.app_name)
    }

    override fun getItemCount(): Int =list.size

}