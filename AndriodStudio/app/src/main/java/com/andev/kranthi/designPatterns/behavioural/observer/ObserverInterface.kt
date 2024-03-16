package com.andev.kranthi.designPatterns.behavioural.observer

interface ObserverInterface {
    fun update(information: String)
    fun update()
    fun setSubject(subject: SubjectInterface): ObserverImp
}