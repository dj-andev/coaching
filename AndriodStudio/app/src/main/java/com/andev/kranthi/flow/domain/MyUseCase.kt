package com.andev.kranthi.flow.domain

import com.andev.kranthi.flow.data.ApiOutCome
import com.andev.kranthi.flow.data.Repository
import com.andev.kranthi.flow.data.model.SampleData
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

class MyUseCase(private val repository: Repository) : UseCaseContract{
    override fun getPostsByRx() : Single<ApiOutCome<List<SampleData>>>{
        return repository.getPostsByRx()
    }

    override suspend fun getPostsByFlow(): Flow<ApiOutCome<List<SampleData>>> {
        return repository.getPostsByFlow()
    }
}