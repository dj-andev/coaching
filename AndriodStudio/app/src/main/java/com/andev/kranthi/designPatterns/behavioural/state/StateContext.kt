package com.andev.kranthi.designPatterns.behavioural.state

/**
 * 1. Create the different states by implementing vechilestate interface
 * 2. Create the StateContext class implementing VehcileState
 * 3. create setstate method inside StateContext and pass required state as params
 */
class StateContext: VehcileState {
    var vehcileState: VehcileState ? = null

    fun setState(vehcileState: VehcileState) {
        this.vehcileState = vehcileState
    }

    fun getState() : VehcileState? = vehcileState

    override fun performAction() {
        vehcileState?.performAction()
    }
}