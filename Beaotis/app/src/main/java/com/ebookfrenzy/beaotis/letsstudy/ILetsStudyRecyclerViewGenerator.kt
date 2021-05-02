package com.ebookfrenzy.beaotis.letsstudy

import com.ebookfrenzy.beaotis.ExampleItem
import com.ebookfrenzy.beaotis.R

interface ILetsStudyRecyclerViewGenerator {
    fun generateLetsStudy():List<ExampleItem>{
        val list = ArrayList<ExampleItem>()
        list.add(
            ExampleItem(
                R.drawable.abc, text1 = "Alfabe",
                R.drawable.numbers, text2 = "Sayılar",
                R.drawable.seasons, text3 = "Mevsimler"
        )
        )
        list.add(
            ExampleItem(
                R.drawable.maths, text1 = "Matematik",
                R.drawable.color_palette, text2 = "Renkler",
                R.drawable.cardgame, text3 = "Alıştırmalar"
        )
        )
        return list
    }
}