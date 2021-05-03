package com.ebookfrenzy.beaotis.findingobjects.vehicles

import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.SubObjectDataClass

interface IVehiclesGenerator {
    fun vehicles_generator():List<SubObjectDataClass>{
        val list=ArrayList<SubObjectDataClass>()
        list.add(SubObjectDataClass(R.drawable.doorkey1))
        return list
    }
}