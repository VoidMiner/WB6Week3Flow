package com.example.wb6weekmultithrdtask11
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainViewModel: ViewModel() {

    private var activeJob: Job? = null

    private var running = true

    private var time = 0
    val timeLiveData = MutableLiveData<Int>()

    fun startTimer() {

        running = true

        if (activeJob?.isActive == true) {
            stopTimer()
        }

        activeJob = viewModelScope.launch() {
            while (running) {
                time++
                timeLiveData.postValue(time)
                delay(1000)
            }
        }
    }

    fun stopTimer() {
        running = false
        if (!running) {
            activeJob?.cancel()
            activeJob = null
        }
    }

    fun resetTimer() {
        time = 0
        timeLiveData.postValue(time)
    }

}
