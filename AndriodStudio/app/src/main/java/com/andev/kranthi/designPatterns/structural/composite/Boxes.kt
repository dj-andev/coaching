package com.andev.kranthi.designPatterns.structural.composite

class Boxes: Product {

    private val productList : ArrayList<Product> = ArrayList()

    override fun getPrice(): Float {
        var sum = 0f
        for (product in productList){
            sum += product.getPrice()
        }
        return sum
    }

    override fun getName(): String {
        return ""
    }

    fun addProduct(product: Product){
        productList.add(product)
    }

    fun removeProduct(product: Product){
        productList.remove(product)
    }

    fun removeAllProduct(){
        productList.clear()
    }
}