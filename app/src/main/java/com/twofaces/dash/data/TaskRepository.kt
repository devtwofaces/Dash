package com.twofaces.dash.data

import com.twofaces.dash.data.db.entities.Task
import com.twofaces.dash.data.db.entities.TaskDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

// API CLASS THAT CONNECTS ROOM SQLITE DB TO OTHER CLASSES

class TaskRepository @Inject constructor (private val taskDao: TaskDao)

{
    suspend fun insert(task: Task){
        taskDao.insertTask(task)
    }

    suspend fun delete(task: Task){
        taskDao.deleteTask(task)
    }

    suspend fun update(task: Task){
        taskDao.updateTask(task)
    }

    suspend fun deleteAll(){
        taskDao.deleteAllTasks()
    }

    fun getAllTasks(): Flow<List<Task>> {
        return taskDao.getAllTasks()
    }






}