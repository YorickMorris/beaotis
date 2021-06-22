package com.ebookfrenzy.beaotis.findingobjects.vegetables

import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.SubObjectDataClass

interface IVegetablesGenerator {
    fun vegetables_generator():List<SubObjectDataClass>{
        val list=ArrayList<SubObjectDataClass>()
        list.add(SubObjectDataClass(R.drawable.vegetablesgroup1))
        list.add(SubObjectDataClass(R.drawable.vegetablesgroup2))
        list.add(SubObjectDataClass(R.drawable.vegetablesgroup3))
        list.add(SubObjectDataClass(R.drawable.doorkey1))
        return list
    }
}