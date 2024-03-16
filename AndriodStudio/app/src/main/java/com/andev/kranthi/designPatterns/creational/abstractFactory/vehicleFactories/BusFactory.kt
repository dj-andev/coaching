package com.andev.kranthi.designPatterns.creational.abstractFactory.vehicleFactories

import com.andev.kranthi.designPatterns.creational.abstractFactory.vehilcleIntances.Bus
import com.andev.kranthi.designPatterns.creational.abstractFactory.vehilcleIntances.Vehicle

class BusFactory(private val engine: String,
                 private val isPowerSteering: Boolean,
                 private val fuelCapacity: Int,
                 private val color: String): VehicleAbstractFactory {

    override fun createVehicle(): Vehicle {
        return Bus(engine, isPowerSteering, fuelCapacity, color)
    }
}