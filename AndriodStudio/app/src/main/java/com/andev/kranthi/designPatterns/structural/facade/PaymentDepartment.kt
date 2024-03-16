package com.andev.kranthi.designPatterns.structural.facade

class PaymentDepartment: PaymentDepartmentInterface {
    override fun paymentDetails(): String {
        return "payment info"
    }

    override fun otherPayPaymentDetails(): String {
        return "other payment info"
    }
}