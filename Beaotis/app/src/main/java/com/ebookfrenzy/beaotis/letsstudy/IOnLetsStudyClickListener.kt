package com.ebookfrenzy.beaotis.letsstudy

import com.ebookfrenzy.beaotis.ExampleItem
import com.ebookfrenzy.beaotis.findingobjects.FindObjectDataClass

interface IOnLetsStudyClickListener {
    fun onItemClicked(data: LetsStudyExampleItem, position: Int)
}