package com.andev.kranthi.designPatterns.behavioural.mediator

class MediatorCompImpl : MediatorComp {

    private val colleaguesList = ArrayList<Colleague>()

    override fun sendInfo(info: String, colleagues: Colleague) {
       for (colleagueItem in colleaguesList) {
           if (colleagueItem != colleagues) {
               colleagueItem.receiveMessage(info)
           }
       }
    }

    override fun addColleague(colleague: Colleague) : MediatorCompImpl{
        if (!colleaguesList.contains(colleague)){
            colleaguesList.add(colleague)
        }
        return this
    }
}