package com.andev.kranthi.designPatterns.structural.adapter

class StockDataProvideClient {

    private var stockDataInterface: StockDataInterface

    constructor() {
        stockDataInterface = StockDataAdapterImp()
    }

    fun getStockInfo(){
       val stockInfo =  stockDataInterface.getStockInfo(2)
    }
}