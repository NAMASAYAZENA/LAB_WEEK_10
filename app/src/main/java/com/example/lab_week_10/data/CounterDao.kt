package com.example.lab_week_10.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CounterDao {

    @Query("SELECT * FROM counter_table ORDER BY id DESC")
    fun getAllTotals(): LiveData<List<CounterEntity>>

    @Insert
    suspend fun insert(counter: CounterEntity)
}
