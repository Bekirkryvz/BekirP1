package com.example.bekir_p1.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {
    var names = mutableStateListOf("Default-Name-1", "Default-Name-2", "Default-Name-3")
    var ages = mutableStateListOf(1, 2, 3)
    var editMode by mutableStateOf(false)
    var currentPage by mutableStateOf(0)
}