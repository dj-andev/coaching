package com.andev.kranthi.designPatterns.creational.builder

/**
 * 1. Create simple outer class with properties
 * 2. Create a static innerclass with all outter class properties
 * 3. Create a private constructor in outter class which accepts static inner builder class reference
 * 4. While building the static inner class take complusary properties as constructor arguments.
 * 5. For option properties prepare setter method and return the innercalss reference.
 * 6. IMPORTANT : create a build() method inside the inner class which return the outer class reference.
 */
class Vehicle {

    // Required params
    private var engine = ""
    private var isPowerSteering = false

    //optional params
    private var color = ""
    private var fuelCapacity = 0

//    Vehicle.VehicleBuilder(para, para).setColor(color).setFuelCapacity().build
    private constructor(vehicleBuilder: VehicleBuilder){
        this.engine = vehicleBuilder.getEngine()
        this.isPowerSteering = vehicleBuilder.isPowerSteering()
        this.color = vehicleBuilder.getColor()
        this.fuelCapacity = vehicleBuilder.getFuelCapacity()
    }

    companion object {
        class VehicleBuilder : VehicleBuilderInterface {
            // Required params
            private var engine = ""
            private var isPowerSteering = false

            //optional params
            private var color = ""
            private var fuelCapacity = 30

            constructor(engine: String, isPowerSteering: Boolean){
                this.engine = engine
                this.isPowerSteering = isPowerSteering
            }

            @Override
            override fun setColor(color: String) : VehicleBuilder{
                this.color = color
                return this
            }

            @Override
            override fun setFuelCapacity(fuelCapacity : Int): VehicleBuilder{
                this.fuelCapacity = fuelCapacity
                return this
            }

            fun getEngine(): String = this.engine
            fun isPowerSteering(): Boolean = this.isPowerSteering
            fun getColor(): String = this.color
            fun getFuelCapacity(): Int = this.fuelCapacity

            @Override
            override fun build() : Vehicle {
                return Vehicle(this)
            }
        }
    }
}