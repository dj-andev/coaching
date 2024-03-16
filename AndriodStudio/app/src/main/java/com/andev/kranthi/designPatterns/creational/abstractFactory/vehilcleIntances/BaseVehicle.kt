package com.andev.kranthi.designPatterns.creational.abstractFactory.vehilcleIntances

open class BaseVehicle constructor(private val engine: String,
                                   private val isPowerSteering: Boolean,
                                   private val fuelCapacity: Int,
                                   private val color: String): Vehicle() {




    override fun engine(): String {
        return engine
    }

    override fun isPowerSteering(): Boolean {
        return isPowerSteering
    }

    override fun fuelCapacity(): Int {
        return fuelCapacity
    }

    override fun color(): String {
        return  color
    }

    override fun toString(): String {
        return super.toString()
    }
}