package com.andev.kranthi.designPatterns.behavioural.state

import android.util.Log

class EngineStartState : VehcileState {
    override fun performAction() {
        Log.i("TAG","Start engine....")
    }
}