package com.ebookfrenzy.beaotis.findingobjects.fruits

import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.SubObjectDataClass

interface IFruitsGenerator {
    fun fruit_generator():List<SubObjectDataClass>{
        val list=ArrayList<SubObjectDataClass>()
        list.add(SubObjectDataClass(R.drawable.fruitsgroup1))
        list.add(SubObjectDataClass(R.drawable.fruitsgroup2))
        list.add(SubObjectDataClass(R.drawable.fruitsgroup3))
        list.add(SubObjectDataClass(R.drawable.doorkey))
        return list
    }
}