package com.andev.kranthi.flow.domain

import com.andev.kranthi.flow.data.ApiOutCome
import com.andev.kranthi.flow.data.model.SampleData
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface UseCaseContract {
    fun getPostsByRx() : Single<ApiOutCome<List<SampleData>>>

    suspend fun getPostsByFlow(): Flow<ApiOutCome<List<SampleData>>>
}