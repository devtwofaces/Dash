package com.twofaces.dash.ui.tasks

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.twofaces.dash.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TasksFragment: Fragment(R.layout.fragment_task_list) {

    private val viewModel: TasksViewModel by viewModels()




}