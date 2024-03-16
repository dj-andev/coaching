package com.andev.kranthi.designPatterns.creational.Factory

import android.util.Log

class AppSpecificRingtone : Ringtone {
    override fun playRingtone() {
        Log.i("TAG", "Play app specific ringtone")
    }

    override fun stopRingtone() {
        Log.i("TAG", "Stop specific ringtone")
    }
}