package com.andev.kranthi.designPatterns.structural.facade

interface CustomerCareOperatorInterface {
    fun deliveryDetails(): String
    fun paymentDetails(): String
    fun itemDetails(): String
}