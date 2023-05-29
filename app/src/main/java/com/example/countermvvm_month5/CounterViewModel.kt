package com.example.countermvvm_month5

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {

    private var count = 0
    val state = MutableLiveData<String>()

    fun incrementCounter(){
        count++
        state.value = count.toString()
    }

    fun decrementCounter(){
        count--
        state.value = count.toString()
    }
}