package com.andev.kranthi.designPatterns.structural.proxy

import android.util.Log

// Real Object
class CashPayment : PaymentInterface {
    override fun processPayment() {
       Log.i("Proxy", "Cash paid...")
    }
}