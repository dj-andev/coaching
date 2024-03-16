package com.andev.kranthi.designPatterns.behavioural.statergy

abstract class Item(protected val barcode: String, protected val price: Float, protected var count: Int) {

    fun getItemPrice(): Float {
        return price * count
    }

    fun getItemBarcode(): String {
        return barcode
    }

}