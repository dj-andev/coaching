package com.andev.kranthi.designPatterns.creational.abstractFactory.vehilcleIntances

class Truck(engine: String,
            isPowerSteering: Boolean,
            fuelCapacity: Int,
            color: String) : BaseVehicle(engine, isPowerSteering, fuelCapacity, color) {
}