package com.andev.kranthi.designPatterns.structural.bridge

import android.util.Log

class Resolution720Px : VideoResolution {

    override fun setupResolution(videoFile: String) {
        Log.i("TAG", "setup 720px resolution")
    }
}