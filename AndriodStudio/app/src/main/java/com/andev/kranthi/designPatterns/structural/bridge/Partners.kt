package com.andev.kranthi.designPatterns.structural.bridge

abstract class Partners(protected var videoResolution: VideoResolution) {
    public abstract fun playVideo(videoFile: String)
}