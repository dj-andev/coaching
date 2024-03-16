package com.andev.kranthi.designPatterns.structural.adapter

class StockDataAdapterImp : StockDataInterface {

    private lateinit var analyticsLibraryInterface: AnalyticsLibraryInterface

    constructor(){
        analyticsLibraryInterface = AnalyticsLibraryImp()
    }

    override fun getStockInfo(type: Int): String {
        val intData = analyticsLibraryInterface.provideDatabasedOnType(type)
        return convertInfo(intData)
    }

    private fun convertInfo(intData : Int): String {
        return intData.toString()
    }
}