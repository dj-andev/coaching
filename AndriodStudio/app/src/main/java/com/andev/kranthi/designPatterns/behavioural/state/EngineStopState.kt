package com.andev.kranthi.designPatterns.behavioural.state

import android.util.Log

class EngineStopState: VehcileState {
    override fun performAction() {
        Log.i("TAG","Stop engine....")
    }
}