package com.andev.kranthi.designPatterns.behavioural.statergy

// type of statergy
interface PaymentGateway {
    fun processPayment(price: Float)
}