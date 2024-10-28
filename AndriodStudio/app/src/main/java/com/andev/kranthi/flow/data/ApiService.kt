package com.andev.kranthi.flow.data

import com.andev.kranthi.flow.data.model.SampleData
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    fun executeRxCall(): Single<List<SampleData>>

    @GET("posts")
    suspend fun getPostsByFlow(): Response<List<SampleData>>
}