package com.example.countermvvm_month5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.countermvvm_month5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var counterViewModel: CounterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // ViewModelProvider нужен для того что бы сохранить данные при повороте экоана или конйигурации
        counterViewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        binding.btnPlus.setOnClickListener {
            counterViewModel.incrementCounter()
        }

        binding.btnMinus.setOnClickListener {
            counterViewModel.decrementCounter()
        }

        counterViewModel.state.observe(this, Observer {
            binding.tvNumber.text = it.toString()
        })
    }
}