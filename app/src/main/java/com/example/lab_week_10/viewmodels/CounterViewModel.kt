package com.example.lab_week_10.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab_week_10.data.CounterRepository
import kotlinx.coroutines.launch

class CounterViewModel(private val repository: CounterRepository) : ViewModel() {

    val allTotals = repository.allTotals

    fun insertNewTotal(total: Int) {
        viewModelScope.launch {
            repository.insertCounter(total)
        }
    }
}
