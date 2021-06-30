package com.ebookfrenzy.beaotis

interface IOnItemClickListener {
     //Özelleştirilmiş onClick methodu.
     fun onItemClicked(data: ExampleItem, position: Int,coloumn: Int)
}