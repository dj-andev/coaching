package com.andev.kranthi.designPatterns.creational.abstractFactory.vehicleFactories

import com.andev.kranthi.designPatterns.creational.abstractFactory.vehilcleIntances.Vehicle

interface VehicleAbstractFactory {
    fun createVehicle() : Vehicle
}