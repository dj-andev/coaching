package com.andev.kranthi.flow.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.andev.kranthi.flow.domain.MyUseCase

class ViewModelFactory(private val repository: Any): ViewModelProvider.Factory{
    override fun <T:ViewModel> create(modelClass: Class<T>):T{
        if (repository is MyUseCase){
            return MyViewmodel(repository as MyUseCase) as T
        }
        throw IllegalArgumentException("UNKNOWN VIEW MODEL CLASS")
    }
}
