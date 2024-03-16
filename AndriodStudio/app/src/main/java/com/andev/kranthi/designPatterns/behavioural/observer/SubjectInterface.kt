package com.andev.kranthi.designPatterns.behavioural.observer

interface SubjectInterface {
    fun register(observer : ObserverInterface): SubjectInterface
    fun unRegister(observer : ObserverInterface)
    fun unRegisterAll()
    fun notifyItems()
    fun getMessage() : String
}