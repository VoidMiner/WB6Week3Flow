package com.example.wb6weekmultithrdtask11


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.MultiThreadTask1.presentation.Fragment1
import com.example.MultiThreadTask1.presentation.Fragment2
import com.example.wb6weekmultithrdtask11.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction().replace(R.id.place_holder, Fragment1.newInstance())
            .commit()
        supportFragmentManager
            .beginTransaction().replace(R.id.place_holder_time, Fragment2.newInstance())
            .commit()

    }

}
