package com.andev.kranthi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FristFragmentViewModel : ViewModel() {

    public fun executeTask() {
        viewModelScope.launch(Dispatchers.IO) {
            //some network calls
            withContext(Dispatchers.Main){

            }
        }
    }
}