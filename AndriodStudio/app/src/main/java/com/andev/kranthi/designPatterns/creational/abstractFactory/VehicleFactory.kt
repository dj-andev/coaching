package com.andev.kranthi.designPatterns.creational.abstractFactory

import com.andev.kranthi.designPatterns.creational.abstractFactory.vehicleFactories.VehicleAbstractFactory
import com.andev.kranthi.designPatterns.creational.abstractFactory.vehilcleIntances.Vehicle

class VehicleFactory {
    companion object {
        fun getVehicle(vehicleAbstractFactor: VehicleAbstractFactory): Vehicle{
            return vehicleAbstractFactor.createVehicle()
        }
    }
}