package com.ebookfrenzy.beaotis.markyourheard

import android.app.Activity
import com.bumptech.glide.Glide
import com.ebookfrenzy.beaotis.R

interface IGenerator {
    fun generateImageGroups():List<ViewPage>{
        val arrayList=ArrayList<ViewPage>()
        arrayList.add(ViewPage(R.drawable.cardgame,R.drawable.cardgame,R.drawable.cardgame))
        arrayList.add(ViewPage(R.drawable.cardgame,R.drawable.cardgame,R.drawable.cardgame))
        arrayList.add(ViewPage(R.drawable.cardgame,R.drawable.cardgame,R.drawable.cardgame))
        arrayList.add(ViewPage(R.drawable.cardgame,R.drawable.cardgame,R.drawable.cardgame))
        arrayList.add(ViewPage(R.drawable.cardgame,R.drawable.cardgame,R.drawable.cardgame))
        arrayList.add(ViewPage(R.drawable.cardgame,R.drawable.cardgame,R.drawable.cardgame))
        arrayList.add(ViewPage(R.drawable.cardgame,R.drawable.cardgame,R.drawable.cardgame))
        arrayList.add(ViewPage(R.drawable.cardgame,R.drawable.cardgame,R.drawable.cardgame))
        arrayList.add(ViewPage(R.drawable.cardgame,R.drawable.cardgame,R.drawable.cardgame))
        arrayList.add(ViewPage(R.drawable.cardgame,R.drawable.cardgame,R.drawable.cardgame))

        return arrayList
    }
}