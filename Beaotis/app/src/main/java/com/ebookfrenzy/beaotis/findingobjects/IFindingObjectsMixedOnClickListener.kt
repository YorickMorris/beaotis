package com.ebookfrenzy.beaotis.findingobjects

import android.widget.ImageView

interface IFindingObjectsMixedOnClickListener {
    fun onItemClicked(data: FindingObjectsDataClass, position: Int,imageView:ImageView)
}