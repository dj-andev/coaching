package com.andev.kranthi.designPatterns.structural.facade

class DeliveryDepartment: DeliveryDepartmentInterface {

    override fun deliveryDetails(): String {
        return "delivery info"
    }

    override fun otherDeliveryDetails(): String {
        return "other delivery Info"
    }
}