package com.ebookfrenzy.beaotis.findingobjects.furnitures

import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.SubObjectDataClass

interface IFurnituresGenerator {
    fun furnitures_generator():List<SubObjectDataClass> {
        val list = ArrayList<SubObjectDataClass>()
        list.add(SubObjectDataClass(R.drawable.furnituresgroup1))
        list.add(SubObjectDataClass(R.drawable.furnituresgroup2))
        list.add(SubObjectDataClass(R.drawable.furnituresgroup3))
        list.add(SubObjectDataClass(R.drawable.furnituresmix))
        return list
    }
}