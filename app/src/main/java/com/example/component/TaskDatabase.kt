package com.example.component

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao

    companion object {
        private var INSTANCE: TaskDatabase? =null
        fun getDatabase(context: Context) : TaskDatabase? {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        databaseBuilder(context, TaskDatabase::class.java, "task")
                            .fallbackToDestructiveMigration()
                            .build()

                }
            }
            return INSTANCE!!
        }
    }
}