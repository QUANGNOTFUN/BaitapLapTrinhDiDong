package com.example.baitaplaptrinhdidong.data.models


data class Task(
    val id: Int,
    val title: String,
    val desImageURL: String,
    val description: String,
    val status: String,
    val priority: String,
    val category: String,
    val dueDate: String,
    val createdAt: String,
    val updatedAt: String,
    val subtasks: List<SubTask>,
    val attachments: List<Attachment>,
    val reminders: List<Reminder>
)

data class SubTask(
    val id: Int,
    val title: String,
    val isCompleted: Boolean
)

data class Attachment(
    val id: Int,
    val fileName: String,
    val fileUrl: String
)

data class Reminder(
    val id: Int,
    val time: String,
    val type: String
)


