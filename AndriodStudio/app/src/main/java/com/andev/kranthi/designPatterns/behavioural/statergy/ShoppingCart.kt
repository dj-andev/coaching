package com.andev.kranthi.designPatterns.behavioural.statergy

/**
 * 1. PaymentGateway is type of statergy
 * 2. Create different payment option based on PaymentGateway
 * 3. prepare the different items for the shopping cart and add to ShoppingCart list
 * 4. Create ShoppingCart which is responsible to execute the payment based upon client selected payment types
 */
class ShoppingCart {
    private val cartList = ArrayList<Item>()

    fun addItem(item: Item){
        cartList.add(item)
    }

    fun removeItem(item: Item){
        cartList.remove(item)
    }

    fun getCartValue(): Float {
        var total = 0f
        for(item in cartList){
            total += item.getItemPrice()
        }
        return total
    }

    fun pay(paymentGateway: PaymentGateway) {
        paymentGateway.processPayment(getCartValue())
    }
}