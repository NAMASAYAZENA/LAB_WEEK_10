package com.example.lab_week_10.data

class CounterRepository(private val dao: CounterDao) {

    val allTotals = dao.getAllTotals()

    suspend fun insertCounter(total: Int) {
        dao.insert(CounterEntity(total = total))
    }
}
