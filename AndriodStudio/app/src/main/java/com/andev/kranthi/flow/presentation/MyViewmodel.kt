package com.andev.kranthi.flow.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.andev.kranthi.flow.data.ApiOutCome
import com.andev.kranthi.flow.data.model.SampleData
import com.andev.kranthi.flow.domain.MyUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class MyViewmodel(private val myUseCase: MyUseCase) : ViewModel() {

    private val liveData = MutableLiveData<ApiOutCome<List<SampleData>>>()
    private val compositeDisposable = CompositeDisposable()

    init{
//        startEmittingSharedFlow() // Notify different value
//        startEmittingSharedFlowSameValue()// Notify same value in sequence
//        startEmittingStateFlow() // Notify different value
//        startEmittingStateFlowSamevalue()// Notify same value in sequence
    }
    fun getDataByRxCall() {
        liveData.value = ApiOutCome.Loading
        compositeDisposable.add(
            myUseCase.getPostsByRx()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ resultState ->
                    liveData.value = resultState
                }, { throwable ->
                    liveData.value = ApiOutCome.Error(throwable.message ?: "Unknown error")
                })
        )
    }

    fun getDataByFlowCall() {
        viewModelScope.launch {
             myUseCase.getPostsByFlow().collect { result ->
                 liveData.value = result
             }
        }
    }

    fun getPostLiveData() : LiveData<ApiOutCome<List<SampleData>>>{
      return liveData
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }



    private val flowValue = flow<Int>{
        for (i in 0..5){
            emit(i)
            delay(1000)
        }
    }
    fun getFlow() = flowValue

    private val stateFlow = MutableStateFlow(0)
    fun getStateFlowFlow() = stateFlow

    fun startEmittingStateFlow(){
       viewModelScope.launch {
           for (i in 0..10) {
               delay(1000)
               stateFlow.emit(i)
           }
       }
    }

    fun startEmittingStateFlowSamevalue(){
        viewModelScope.launch {
            for (i in 0..10) {
                delay(1000)
                stateFlow.emit(10)
            }
        }
    }

    private val shareFlow = MutableSharedFlow<Int>()
    fun getSharedFlowFlow() = shareFlow

     fun startEmittingSharedFlow(){
        viewModelScope.launch {
            repeat(10){
                delay(1000)
                shareFlow.emit(it)
            }
        }
    }

    fun startEmittingSharedFlowSameValue(){
        viewModelScope.launch {
            repeat(10){
                delay(1000)
                shareFlow.emit(10)
            }
        }
    }
}