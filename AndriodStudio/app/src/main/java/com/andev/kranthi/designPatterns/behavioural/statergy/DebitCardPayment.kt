package com.andev.kranthi.designPatterns.behavioural.statergy

import android.util.Log

class DebitCardPayment(private val name: String, private val pin: Int): PaymentGateway {
    override fun processPayment(price: Float) {
        Log.i("TAG", "Paying though the debit card...")
    }
}