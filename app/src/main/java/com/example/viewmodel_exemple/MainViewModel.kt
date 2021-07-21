package com.example.mvvmexemple

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _countLiveData = MutableLiveData(0)
    val countLiveData: LiveData<Int>
        get() = _countLiveData


    fun plus() {
        val count = _countLiveData.value ?: 0 //count는 _countLiveData의 value값을 받는데 만약 null일땐 0이다.
        _countLiveData.value = count + 1 //plus가 실행되면 _countLiveData의 밸류값에 count + 1을 해준다.
    }

    fun minus() {
        val count = _countLiveData.value ?: 0
        _countLiveData.value = count - 1
    }

    fun multiply() {
        val count = _countLiveData.value ?: 0
        _countLiveData.value = count * 3
    }

    fun division() {
        val count = _countLiveData.value ?: 0
        _countLiveData.value = count / 3
    }

    fun clear() {
        _countLiveData.value = 0
    }


}