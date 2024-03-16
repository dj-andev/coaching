package com.andev.kranthi.designPatterns.structural.bridge

import android.util.Log

class YoutubePartener(videoResolution: VideoResolution): Partners(videoResolution)  {

    override fun playVideo(videoFile : String){
        videoResolution.setupResolution(videoFile)
        playVideo()
    }

    private fun playVideo() {
        Log.i("TAG", "Play video file")
    }
}