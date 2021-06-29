package com.ebookfrenzy.beaotis.letsstudy

import com.ebookfrenzy.beaotis.R

interface INumbersGenerator {
    fun generateList():List<LetsStudyExampleItem>{
        val itemList=ArrayList<LetsStudyExampleItem>()
        itemList.add(
            LetsStudyExampleItem(R.drawable.zero,R.raw.sifir)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.one,R.raw.bir)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.two,R.raw.iki)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.three,R.raw.uc)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.four,R.raw.dort)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.five,R.raw.bes)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.six,R.raw.alti)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.seven,R.raw.yedi)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.eight,R.raw.sekiz)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.nine,R.raw.dokuz)
        )

        return itemList

    }
}