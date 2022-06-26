package com.example.wb6weekmultithrdtask11


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.wb6weekmultithrdtask11.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction().replace(R.id.place_holder, FragmentCalc.newInstance())
            .commit()
        supportFragmentManager
            .beginTransaction().replace(R.id.place_holder_time, FragmentTimer.newInstance())
            .commit()
    }
}
