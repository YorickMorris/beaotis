package com.ebookfrenzy.beaotis.findingobjects

import android.util.Log
import com.ebookfrenzy.beaotis.R

interface IFindingObjectsMixedGenerator {
    fun mixed_generateList():MutableList<FindingObjectsDataClass>{
        val list= mutableListOf<FindingObjectsDataClass>()
        list.add(FindingObjectsDataClass(R.drawable.ananas,R.raw.ananas))
        list.add(FindingObjectsDataClass(R.drawable.elma,R.raw.elma))
        list.add(FindingObjectsDataClass(R.drawable.armut,R.raw.armut))
        list.add(FindingObjectsDataClass(R.drawable.kiraz,R.raw.kiraz))
        list.add(FindingObjectsDataClass(R.drawable.uzum,R.raw.uzum))
        list.add(FindingObjectsDataClass(R.drawable.cilek,R.raw.cilek))
        list.add(FindingObjectsDataClass(R.drawable.karpuz,R.raw.karpuz))
        list.add(FindingObjectsDataClass(R.drawable.limon,R.raw.limon))
        list.add(FindingObjectsDataClass(R.drawable.muz,R.raw.muz))

        return list
    }
    fun getSoundResources(list:MutableList<FindingObjectsDataClass>):MutableList<Int>{
        val newList = mutableListOf<Int>()
        for (items in list.indices){
            newList.add(items,list[items].soundResource)
            Log.d("Dizi: ","$newList")
        }
        newList.shuffle()
        return newList
    }

}