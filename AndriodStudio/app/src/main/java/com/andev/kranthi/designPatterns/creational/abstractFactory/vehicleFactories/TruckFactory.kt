package com.andev.kranthi.designPatterns.creational.abstractFactory.vehicleFactories

import com.andev.kranthi.designPatterns.creational.abstractFactory.vehilcleIntances.Bus
import com.andev.kranthi.designPatterns.creational.abstractFactory.vehilcleIntances.Truck
import com.andev.kranthi.designPatterns.creational.abstractFactory.vehilcleIntances.Vehicle

class TruckFactory (private val engine: String,
                    private val isPowerSteering: Boolean,
                    private val fuelCapacity: Int,
                    private val color: String): VehicleAbstractFactory {

    override fun createVehicle(): Vehicle {
        return Truck(engine, isPowerSteering, fuelCapacity, color)
    }
}