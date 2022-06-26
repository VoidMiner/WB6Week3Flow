package com.example.wb6weekmultithrdtask11


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.wb6weekmultithrdtask11.databinding.FragmentCalculationBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigDecimal


class FragmentCalc : Fragment() {
    private lateinit var binding: FragmentCalculationBinding
    private val const: Double = 4.0
    private var x: Int = 1
    private var y = BigDecimal(4)
    private var count: Long = 0
    private var z = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch(Dispatchers.Default) {// рассчет числа пи жесточайщий (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
            while (true) {
                if (count % 2 == 0.toLong()) {
                    y -= BigDecimal(const).divide(BigDecimal(x + 2), 300, 3)
                    z = y.toString()
                    x += 2
                } else {
                    y += BigDecimal(const).divide(BigDecimal(x + 2), 300, 3)
                    z = y.toString()
                    x += 2
                }
                if (x % 50000 == 1) {
                    binding.tvCalc.text = z.substring(0, 300)
                }
                count++
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = FragmentCalc()
    }
}