package com.andev.kranthi.designPatterns.behavioural.mediator

abstract class Colleague {
    protected  var mediatorComp: MediatorComp
    protected var userInfo: String ?= null

    constructor(mediatorComp: MediatorComp, userInfo: String){
        this.mediatorComp = mediatorComp
        this.userInfo = userInfo
    }

    abstract fun pushMessage(info: String)
    abstract fun receiveMessage(info: String)
}