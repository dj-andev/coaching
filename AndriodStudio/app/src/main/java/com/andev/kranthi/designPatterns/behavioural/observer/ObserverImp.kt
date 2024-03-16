package com.andev.kranthi.designPatterns.behavioural.observer

import android.util.Log

class ObserverImp() : ObserverInterface {
    private lateinit var subjectInterface: SubjectInterface

    override fun update(information: String) {
        Log.i("TAG", "notification received with data : $information")
    }

    override fun update() {
      Log.i("TAG", "notification received")
        //Based on some rule
        val messsage  = subjectInterface.getMessage()
        Log.i("TAG", "notification received mesage : $messsage" )
    }

    override fun setSubject(subject: SubjectInterface) : ObserverImp{
        subjectInterface = subject
        return this
    }
}