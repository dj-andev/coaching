package com.andev.kranthi.designPatterns.creational.Factory

import android.util.Log

class CustomRingtone : Ringtone {
    override fun playRingtone() {
        Log.i("TAG", "Play custom ringtone")
    }

    override fun stopRingtone() {
        Log.i("TAG", "Stop custom ringtone")
    }
}