package com.andev.kranthi.designPatterns.behavioural.observer

/**
 * Single subject with multiple observer
 */
class SubjectImp : SubjectInterface {
    private val list = ArrayList<ObserverInterface>()
    private var information = ""

    override fun register(observer: ObserverInterface) : SubjectInterface {
        // add observer to subject
       if (!list.contains(observer)){
           list.add(observer)
       }
        return this
    }

    override fun unRegister(observer: ObserverInterface) {
        // removing the observer from subject
        list.remove(observer)
    }

    override fun unRegisterAll() {
        // removing all observers from subject
        list.clear()
    }

    override fun notifyItems() {
        for (observer in list) {
            observer.update(information)
            observer.update()
        }
    }

    override fun getMessage() :  String{
        return information
    }


    fun setInformation(information: String){
        this.information = information
        notifyItems()
    }
}