package com.andev.kranthi.designPatterns.creational.builder

interface VehicleBuilderInterface {
    fun setColor(color: String) : Vehicle.Companion.VehicleBuilder
    fun setFuelCapacity(fuelCapacity : Int): Vehicle.Companion.VehicleBuilder
    fun build(): Vehicle
}