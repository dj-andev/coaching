package com.andev.kranthi.designPatterns.structural.proxy

//Proxy Object
class DebitCardPayment(private val cashPayment: PaymentInterface): PaymentInterface {

    private var passcode : String = ""
    private var username : String = ""

    fun addCredentials(username : String , passcode : String){
        this.passcode = passcode
        this.username = username
    }

    override fun processPayment() {
        if (checkAccess()){
            cashPayment.processPayment()
        }
    }

    private fun checkAccess(): Boolean{
        // Network call to check user has the access or not
        if (passcode.equals("abc") && username. equals("1234")){
            return true
        }
        return false
    }
}