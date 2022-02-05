package com.example.component

import com.example.component.components.EmptyMessage
import FAB
import TaskCard
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider
import com.example.component.ui.theme.ComponentTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    lateinit var taskDao: TaskDao
    private val TAG = "main_activity"

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        taskDao = TaskDatabase.getDatabase(this)?.taskDao()!!


        val repository = TaskRepository(taskDao)

        val taskModel: TaskViewModel =
            ViewModelProvider(this, TaskViewModelFactory(repository)).get(TaskViewModel::class.java)

        setContent {

            val tasks by taskModel.tasks.observeAsState(initial = emptyList<Task>())

            Log.d("Home Screen", tasks.size.toString())
            val systemUiController = rememberSystemUiController()
            val task=Task(id =0, task = "Go to gym")
            SideEffect {
                systemUiController.setStatusBarColor(color = Color.Transparent, darkIcons = true)
            }

            ComponentTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    HomeScreen(
                        tasks = tasks,
                        insertData = { taskModel.insertTask(task) }
                    )
                }
            }
        }
    }
}


@ExperimentalMaterial3Api
@Composable
fun HomeScreen(tasks: List<Task>, insertData: () -> Unit) {

    Scaffold(
        backgroundColor = MaterialTheme.colorScheme.surface,
        floatingActionButton = {
            FAB(onClick = insertData)
        },

        ) {
        if (tasks.isEmpty()) EmptyMessage()
        else
        LazyColumn {
            items(count = tasks.count(), itemContent = { index -> TaskCard(tasks[index]) })
        }

    }
}










