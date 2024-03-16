package com.andev.kranthi.designPatterns.creational.Factory

import android.util.Log

class SystemRingtone: Ringtone {
    override fun playRingtone() {
        Log.i("TAG", "Play system ringtone")
    }

    override fun stopRingtone() {
        Log.i("TAG", "Stop system ringtone")
    }
}