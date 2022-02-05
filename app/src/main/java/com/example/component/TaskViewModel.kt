package com.example.component

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(private val taskRepository: TaskRepository): ViewModel() {
    private val _task=taskRepository.getTasks()

    val tasks:LiveData<List<Task>>
        get() =_task

    fun getTasks(): List<Task>? {
        return _task.value
    }

    fun insertTask( task:Task){
        viewModelScope.launch(Dispatchers.IO) {
            taskRepository.insertTask(task)

        }
    }
}