package com.example.lab_week_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.lab_week_10.data.AppDatabase
import com.example.lab_week_10.data.CounterRepository
import com.example.lab_week_10.databinding.ActivityMainBinding
import com.example.lab_week_10.viewmodel.CounterViewModel
import com.example.lab_week_10.viewmodel.CounterViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: CounterViewModel by viewModels {
        CounterViewModelFactory(
            CounterRepository(
                AppDatabase.getDatabase(this).counterDao()
            )
        )
    }

    private var currentTotal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonIncrement.setOnClickListener {
            currentTotal++
            binding.textTotal.text = currentTotal.toString()
        }

        binding.buttonSave.setOnClickListener {
            viewModel.insertNewTotal(currentTotal)
        }

        binding.buttonHistory.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HistoryFragment())
                .addToBackStack(null)
                .commit()
        }
    }
}
