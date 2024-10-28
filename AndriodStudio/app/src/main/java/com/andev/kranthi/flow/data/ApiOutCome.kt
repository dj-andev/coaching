package com.andev.kranthi.flow.data

sealed class ApiOutCome<out T> {
    object Loading : ApiOutCome<Nothing>()
    data class Success<out T>(val data: T) : ApiOutCome<T>()
    data class Error(val message: String) : ApiOutCome<Nothing>()
}