package com.andev.kranthi.designPatterns.structural.bridge

import android.util.Log

class Resolution8KPx  : VideoResolution {

    override fun setupResolution(videoFile: String) {
        Log.i("TAG", "setup 1040px resolution")
    }
}