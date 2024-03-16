package com.andev.kranthi.designPatterns.structural.adapter

class AnalyticsLibraryImp: AnalyticsLibraryInterface {

    override fun provideDatabasedOnType(type: Int): Int {
        return when(type){
            1 -> 100
            2 -> 20
            3 -> 50
            else -> 200
        }
    }
}