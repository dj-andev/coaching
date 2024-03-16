package com.andev.kranthi.designPatterns.behavioural.iterator

class DataContainer: Container {

    private val list = (1..1000).toList()
    override fun getIterator(): Iterator {
       return DataIterator(list as ArrayList<Int>)
    }
}