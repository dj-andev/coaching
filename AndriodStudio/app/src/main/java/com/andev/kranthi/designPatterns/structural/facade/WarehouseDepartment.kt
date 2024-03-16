package com.andev.kranthi.designPatterns.structural.facade

class WarehouseDepartment: WarehouseDepartmentInterface {
    override fun itemDetails(): String {
        return "warehouse item info"
    }

    override fun otherItemDetails(): String {
        return "other warehouse item info"
    }
}