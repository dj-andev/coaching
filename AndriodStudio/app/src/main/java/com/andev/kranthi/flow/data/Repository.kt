package com.andev.kranthi.flow.data

import com.andev.kranthi.flow.data.model.SampleData
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository(private val apiService: ApiService) {

    fun getPostsByRx() : Single<ApiOutCome<List<SampleData>>> {
        return apiService.executeRxCall()
            .map<ApiOutCome<List<SampleData>>> { ApiOutCome.Success(it) }
            .onErrorReturn { exp -> ApiOutCome.Error(exp.message ?: "Unknown error") }
            .subscribeOn(Schedulers.io())
    }


    suspend fun getPostsByFlow()  = flow {
        emit(ApiOutCome.Loading) // Emit loading state
        try {
            val response = apiService.getPostsByFlow()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(ApiOutCome.Success(it)) // Emit success with data
                } ?: emit(ApiOutCome.Error("No data available"))
            } else {
                emit(ApiOutCome.Error("Error: ${response.code()}"))
            }
        } catch (e: Exception) {
            emit(ApiOutCome.Error(e.message ?: "Unknown error"))
        }
    }.catch { e ->
        emit(ApiOutCome.Error(e.message ?: "Unknown error")) // Handle exceptions
    }.flowOn(Dispatchers.IO) // Ensure this runs on the IO dispatcher
}