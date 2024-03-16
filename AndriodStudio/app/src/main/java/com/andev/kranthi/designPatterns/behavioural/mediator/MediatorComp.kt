package com.andev.kranthi.designPatterns.behavioural.mediator

interface MediatorComp {
    fun sendInfo(info: String, colleague: Colleague)
    fun addColleague(colleague: Colleague): MediatorCompImpl
}