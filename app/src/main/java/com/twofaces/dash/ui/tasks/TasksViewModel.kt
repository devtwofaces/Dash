package com.twofaces.dash.ui.tasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.twofaces.dash.data.TaskRepository
import com.twofaces.dash.data.db.entities.Task
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor (private val taskRepository: TaskRepository) : ViewModel()

{

    fun insert(task: Task) = viewModelScope.launch {
        taskRepository.insert(task)
    }





}