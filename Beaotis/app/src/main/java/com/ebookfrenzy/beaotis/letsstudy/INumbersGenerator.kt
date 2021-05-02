package com.ebookfrenzy.beaotis.letsstudy

import com.ebookfrenzy.beaotis.R

interface INumbersGenerator {
    fun generateList():List<LetsStudyExampleItem>{
        val itemList=ArrayList<LetsStudyExampleItem>()
        itemList.add(
            LetsStudyExampleItem(R.drawable.zero)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.one)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.two)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.three)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.four)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.five)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.six)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.seven)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.eight)
        )
        itemList.add(
            LetsStudyExampleItem(R.drawable.nine)
        )

        return itemList

    }
}