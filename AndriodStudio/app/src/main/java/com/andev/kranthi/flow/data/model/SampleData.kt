package com.andev.kranthi.flow.data.model

import com.google.gson.annotations.SerializedName

data class SampleData(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String)