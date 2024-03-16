package com.andev.kranthi.designPatterns.creational.abstractFactory.vehilcleIntances

class Van(engine: String,
          isPowerSteering: Boolean,
          fuelCapacity: Int,
          color: String) : BaseVehicle(engine, isPowerSteering, fuelCapacity, color) {
}