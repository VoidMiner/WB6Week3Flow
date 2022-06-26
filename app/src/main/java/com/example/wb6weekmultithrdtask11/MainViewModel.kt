package com.example.wb6weekmultithrdtask11

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


class MainViewModel : ViewModel() {
    init {// инициалзиация при создании viewModel
        startTimer()
    }

    private var activeJob: Job? = null

    private var running = true

    private var time = 0
    private var minutes = 0
    private var seconds = 0
    var clock = MutableStateFlow("00:00")
    val timeFlow = MutableStateFlow(0)

    fun startTimer() {

        running = true

        if (activeJob?.isActive == true) {
            stopTimer()
        }
        activeJob = viewModelScope.launch() {
            while (running) {
                seconds++
                timeFlow.value = seconds
                if (seconds == 59) {
                    seconds = 0
                    minutes++

                }
                var secStr = "0$seconds"
                if (seconds < 10) {
                    secStr = "0$seconds"
                } else {
                    secStr = "$seconds"
                }
                var minStr = "0$minutes"
                if (minutes < 10) {
                    minStr = "0$minutes"
                } else minStr = "$minutes"

                clock.value = "$minStr:$secStr"
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
        seconds = 0
        timeFlow.value = seconds
    }

}
