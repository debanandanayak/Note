package com.example.component

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert(onConflict = IGNORE)
    suspend fun insert(vararg task: Task)

    @Query("SELECT * FROM task")
    fun getTasks(): LiveData<List<Task>>
}