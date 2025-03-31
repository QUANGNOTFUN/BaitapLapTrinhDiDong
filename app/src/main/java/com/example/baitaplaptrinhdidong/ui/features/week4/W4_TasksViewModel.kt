package com.example.baitaplaptrinhdidong.ui.features.week4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.baitaplaptrinhdidong.data.models.Task
import com.example.baitaplaptrinhdidong.data.network.RetrofitInstance
import com.example.baitaplaptrinhdidong.data.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TasksViewModel : ViewModel() {
    private val _repos = TaskRepository(RetrofitInstance.api)

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> get() = _tasks

    private val _task = MutableStateFlow<Task?>(null)
    val task: StateFlow<Task?> get() = _task

    init {
        fetchTasks()
    }

    private fun fetchTasks() {
        viewModelScope.launch {
            try {
                val response = _repos.getTasks()
                if (response.body()?.isSuccess == true) {
                    _tasks.value = response.body()?.data ?: emptyList()
                } else {
                    println("API trả về lỗi: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                println("Lỗi kết nối API: ${e.message}")
            }
        }
    }

    fun fetchTask(id: Int) {
        viewModelScope.launch {
            try {
                val response = _repos.getTask(id)
                if (response.body()?.isSuccess == true) {
                    _task.value = response.body()!!.data
                } else {
                    println("API trả về lỗi: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                println("Lỗi kết nối API: ${e.message}")
            }
        }
    }
}
