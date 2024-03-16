package com.andev.kranthi.designPatterns.creational.abstractFactory.vehilcleIntances

abstract class Vehicle {
     abstract fun engine(): String
     abstract fun isPowerSteering(): Boolean
     abstract fun fuelCapacity(): Int
     abstract fun color(): String

    override fun toString(): String {
        return super.toString()
    }
}