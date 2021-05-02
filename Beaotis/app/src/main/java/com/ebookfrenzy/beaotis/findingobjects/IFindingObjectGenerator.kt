package com.ebookfrenzy.beaotis.findingobjects

import com.ebookfrenzy.beaotis.R


interface IFindingObjectGenerator {
    fun generateList():List<FindObjectDataClass>{
        val list=ArrayList<FindObjectDataClass>()
        list.add(FindObjectDataClass(R.drawable.fruits,"Meyveler"))
        list.add(FindObjectDataClass(R.drawable.vegetable,"Sebzeler"))
        list.add(FindObjectDataClass(R.drawable.vehicle,"Taşıtlar"))
        list.add(FindObjectDataClass(R.drawable.furnitures,"Eşyalar"))
        return list
    }
}