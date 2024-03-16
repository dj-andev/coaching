package com.andev.kranthi.designPatterns.structural.facade

/**
 * Prepare required obstract methods inside facade interface
 * Implement those abstract method inside facade class.
 * Prepare diffrent components class and interfaces.
 */
class CustomerCareOperatorFacade: CustomerCareOperatorInterface {

    override fun deliveryDetails(): String {
      val deliveryDepartment = DeliveryDepartment()
      return deliveryDepartment.deliveryDetails()
    }

    override fun paymentDetails(): String {
        val paymentDepartment = PaymentDepartment()
        return paymentDepartment.paymentDetails()
    }

    override fun itemDetails(): String {
        val warehouseDepartment = WarehouseDepartment()
        return warehouseDepartment.itemDetails()
    }
}