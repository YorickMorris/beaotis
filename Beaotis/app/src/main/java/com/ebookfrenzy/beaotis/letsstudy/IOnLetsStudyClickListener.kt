package com.ebookfrenzy.beaotis.letsstudy

import android.widget.ImageView
import com.ebookfrenzy.beaotis.ExampleItem
import com.ebookfrenzy.beaotis.findingobjects.FindObjectDataClass

interface IOnLetsStudyClickListener {
    fun onItemClicked(data: LetsStudyExampleItem, position: Int,imageView:ImageView)
}