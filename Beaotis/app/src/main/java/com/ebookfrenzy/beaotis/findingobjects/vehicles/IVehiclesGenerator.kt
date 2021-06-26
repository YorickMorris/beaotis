package com.ebookfrenzy.beaotis.findingobjects.vehicles

import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.SubObjectDataClass

interface IVehiclesGenerator {
    fun vehicles_generator():List<SubObjectDataClass>{
        val list=ArrayList<SubObjectDataClass>()
        list.add(SubObjectDataClass(R.drawable.vehiclesgroup1))
        list.add(SubObjectDataClass(R.drawable.vehiclesgroup2))
        list.add(SubObjectDataClass(R.drawable.vehiclesgroup3))
        list.add(SubObjectDataClass(R.drawable.vehiclesmix))
        return list
    }
}