package com.andev.kranthi.designPatterns.structural.composite

class ProductItem(private val price: Float, private val name: String) : Product {

    override fun getPrice(): Float {
        return price
    }

    override fun getName(): String {
        return name
    }
}