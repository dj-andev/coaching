package com.andev.kranthi.designPatterns.behavioural.iterator

class DataIterator(val itemList : ArrayList<Int>): Iterator {
    private var index = 0

    override fun hasNext(): Boolean {
        //add all your filter based on business requirement.
       if (index < itemList.size && (itemList[index + 1] % 2 == 0)){
           return true
       }
      return false
    }

    override fun next(): Any? {
        if (hasNext()) {
            return itemList[index++]
        }
        return null
    }
}