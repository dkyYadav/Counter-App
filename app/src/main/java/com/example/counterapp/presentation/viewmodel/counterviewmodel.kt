package com.example.counterapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CounterViewModel : ViewModel() {
    // your logic here
        private  var _count = MutableStateFlow(0)
    var counter: StateFlow<Int> = _count

    fun increment(){
        _count.value++
    }

    fun reset(){
        _count.value = 0
    }

    fun decrement(){
        _count.value--
    }
}