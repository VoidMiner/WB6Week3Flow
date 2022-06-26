package com.example.wb6weekmultithrdtask11

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.wb6weekmultithrdtask11.databinding.FragmentTimerBinding
import java.util.*


class FragmentTimer : Fragment() {

    private val viewModel: MainViewModel by viewModels()
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
        val rnd = Random()

        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))

        viewModel.timeLiveData.observe(viewLifecycleOwner) {
            binding.time.text = "Time $it"
            if (it % 20 == 0) {
                binding.notificationBackground.setBackgroundColor(color)
            }
        }

        binding.apply {
            playTimer.setOnClickListener { viewModel.startTimer() }
            pauseTimer.setOnClickListener { viewModel.stopTimer() }
            resetTimer.setOnClickListener { viewModel.resetTimer() }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentTimer()
    }
}