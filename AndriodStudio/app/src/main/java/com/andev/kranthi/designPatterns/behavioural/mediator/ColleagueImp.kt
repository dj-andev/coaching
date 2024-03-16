package com.andev.kranthi.designPatterns.behavioural.mediator

import android.util.Log

class ColleagueImp(mediatorComp: MediatorComp, userInfo: String) : Colleague(mediatorComp, userInfo) {

    override fun pushMessage(info: String) {
        mediatorComp.sendInfo(info, this)
    }

    override fun receiveMessage(info: String) {
        Log.i("TAG", "Received message : $info")
    }
}