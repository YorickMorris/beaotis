package com.ebookfrenzy.beaotis

interface IGeneratorInterface {
     fun generateList(): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        list.add(
            ExampleItem(
                R.drawable.binoculars, text1 = "Nesneleri Bul",
                R.drawable.teach, text2 = "Öğrenelim",
                R.drawable.cardgame, text3 = "Eşleştirme"
            )
        )
        list.add(
            ExampleItem(
                R.drawable.storytelling, text1 = "Bir Hikayem Var",
                R.drawable.listening, text2 = "Eğitici Şarkılar",
                R.drawable.parchment, text3 = "Görgü Kuralları"
            )
        )
        return list
    }
}