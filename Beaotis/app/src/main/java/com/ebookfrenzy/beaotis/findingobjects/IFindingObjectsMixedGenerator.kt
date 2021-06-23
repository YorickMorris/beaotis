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
        list.add(FindingObjectsDataClass(R.drawable.portakal,R.raw.portakal))
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

    fun mixed_furnitures() : MutableList<FindingObjectsDataClass>{
        val list= mutableListOf<FindingObjectsDataClass>()
        list.add(FindingObjectsDataClass(R.drawable.etek,R.raw.etek))
        list.add(FindingObjectsDataClass(R.drawable.masa,R.raw.masa))
        list.add(FindingObjectsDataClass(R.drawable.bicak,R.raw.bicak))
        list.add(FindingObjectsDataClass(R.drawable.yatak,R.raw.yatak))
        list.add(FindingObjectsDataClass(R.drawable.pantalon,R.raw.pantolon))
        list.add(FindingObjectsDataClass(R.drawable.catal,R.raw.catal))
        list.add(FindingObjectsDataClass(R.drawable.tsort,R.raw.tisort))
        list.add(FindingObjectsDataClass(R.drawable.sandalye,R.raw.sandalye))
        list.add(FindingObjectsDataClass(R.drawable.kasik,R.raw.kasik))

        return list
    }

    fun mixed_vegetables() : MutableList<FindingObjectsDataClass>{
        val list= mutableListOf<FindingObjectsDataClass>()
        list.add(FindingObjectsDataClass(R.drawable.patates,R.raw.patates))
        list.add(FindingObjectsDataClass(R.drawable.sogan,R.raw.sogan))
        list.add(FindingObjectsDataClass(R.drawable.salatalik,R.raw.salatalik))
        list.add(FindingObjectsDataClass(R.drawable.biber,R.raw.biber))
        list.add(FindingObjectsDataClass(R.drawable.sarimsak,R.raw.sarimsak))
        list.add(FindingObjectsDataClass(R.drawable.havuc,R.raw.havuc))
        list.add(FindingObjectsDataClass(R.drawable.patlican,R.raw.patlican))
        list.add(FindingObjectsDataClass(R.drawable.domates,R.raw.domates))
        list.add(FindingObjectsDataClass(R.drawable.limon,R.raw.limon))

        return list
    }

    fun mixed_vehicles() : MutableList<FindingObjectsDataClass>{
        val list= mutableListOf<FindingObjectsDataClass>()
        list.add(FindingObjectsDataClass(R.drawable.ucak,R.raw.ucak))
        list.add(FindingObjectsDataClass(R.drawable.gemi,R.raw.gemi))
        list.add(FindingObjectsDataClass(R.drawable.tren,R.raw.tren))
        list.add(FindingObjectsDataClass(R.drawable.araba,R.raw.araba))
        list.add(FindingObjectsDataClass(R.drawable.balon,R.raw.balon))
        list.add(FindingObjectsDataClass(R.drawable.motorsiklet,R.raw.motorsiklet))
        list.add(FindingObjectsDataClass(R.drawable.bisiklet,R.raw.bisiklet))
        list.add(FindingObjectsDataClass(R.drawable.kamyon,R.raw.kamyon))
        list.add(FindingObjectsDataClass(R.drawable.otobus,R.raw.otobus))

        return list
    }

}