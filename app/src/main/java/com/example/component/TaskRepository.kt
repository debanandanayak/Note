package com.example.component

import android.util.Log
import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao:TaskDao) {
    fun getTasks(): LiveData<List<Task>> {
        return taskDao.getTasks()
    }
    init {
        Log.d("Repo Home", taskDao.getTasks().value?.size.toString())
    }
    suspend fun insertTask(task:Task){
        taskDao.insert(task)
    }

}