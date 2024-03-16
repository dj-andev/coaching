package com.andev.kranthi.designPatterns.behavioural.statergy

import android.util.Log

class CashPayment: PaymentGateway {
    override fun processPayment(price: Float) {
      Log.i("TAG", "Paying though the cash...")
    }
}