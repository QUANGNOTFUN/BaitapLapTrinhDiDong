package com.example.baitaplaptrinhdidong.ui.features.week6

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class TaskModel(
    val task: String = "",
    val description: String = ""
)

class W6ViewModel(context: Context): ViewModel() {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("TaskPrefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    private val _listTasks: MutableStateFlow<List<TaskModel>> = MutableStateFlow(loadTasks())
    val listTasks = _listTasks.asStateFlow()

    private val _taskState = MutableStateFlow(TaskModel())
    val taskState = _taskState.asStateFlow()

    init {
        if (_listTasks.value.isEmpty()) {
            _listTasks.value = listOf(TaskModel(
                "Complete Android Project",
                "Finish the UI, integrate API, and write documentation"
            ))
            saveTasks(_listTasks.value)
        }
    }

    fun onChangeTask(text: String) {
        _taskState.value = _taskState.value.copy(
            task = text
        )
    }

    fun onChangeDescription(text: String) {
        _taskState.value = _taskState.value.copy(
            description = text
        )
    }

    fun addNewTask() {
        viewModelScope.launch {
            _listTasks.update { it + _taskState.value }
            _taskState.value = TaskModel()
        }
    }

    private fun saveTasks(tasks: List<TaskModel>) {
        val json = gson.toJson(tasks)
        sharedPreferences.edit().putString("tasks", json).apply()
    }

    private fun loadTasks(): List<TaskModel> {
        val json = sharedPreferences.getString("tasks", null)
        return if (json != null) {
            val type = object : TypeToken<List<TaskModel>>() {}.type
            gson.fromJson(json, type) ?: emptyList()
        } else {
            emptyList()
        }
    }
}

class W6ListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(W6ViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return W6ViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}