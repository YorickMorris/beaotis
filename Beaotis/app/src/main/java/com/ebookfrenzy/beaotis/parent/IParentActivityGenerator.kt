package com.ebookfrenzy.beaotis.parent

import com.ebookfrenzy.beaotis.R
import com.ebookfrenzy.beaotis.findingobjects.FindObjectDataClass

interface IParentActivityGenerator {
    fun paren_generatorList():List<FindObjectDataClass>{
        val list=ArrayList<FindObjectDataClass>()
        list.add(FindObjectDataClass(R.drawable.fruits,"Meyveler"))
        list.add(FindObjectDataClass(R.drawable.vegetable,"Sebzeler"))
        list.add(FindObjectDataClass(R.drawable.vehicle,"Taşıtlar"))
        list.add(FindObjectDataClass(R.drawable.furnitures,"Eşyalar"))
        return list
    }
}