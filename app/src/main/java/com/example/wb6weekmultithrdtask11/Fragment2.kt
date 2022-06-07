package com.example.MultiThreadTask1.presentation

import android.graphics.Color
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer.OnChronometerTickListener
import androidx.fragment.app.Fragment
import com.example.wb6weekmultithrdtask11.databinding.FragmentTimerBinding
import java.util.*


class Fragment2 : Fragment() {
    lateinit var binding: FragmentTimerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTimerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.watch.format = "Time: %s"
        binding.watch.base = SystemClock.elapsedRealtime()
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        binding.watch.onChronometerTickListener = OnChronometerTickListener { chronometer ->
            if (SystemClock.elapsedRealtime() - chronometer.base >= 20000) {
                binding.notificationBackground.setBackgroundColor(color)
            }
        }
        binding.apply {
            playTimer.setOnClickListener { watch.start() }
            pauseTimer.setOnClickListener { watch.stop() }
            resetTimer.setOnClickListener { watch.base = SystemClock.elapsedRealtime() }
        }
    }

    override fun onStart() {
        super.onStart()
        binding.watch.start()
    }

    override fun onStop() {
        super.onStop()
        binding.watch.stop()
    }


    companion object {

        @JvmStatic
        fun newInstance() = Fragment2()
    }
}