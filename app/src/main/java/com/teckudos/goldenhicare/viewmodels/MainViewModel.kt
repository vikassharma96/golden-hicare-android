package com.teckudos.goldenhicare.viewmodels

import androidx.lifecycle.ViewModel
import com.teckudos.goldenhicare.domain.Category
import com.teckudos.goldenhicare.domain.Item
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class MainViewModel : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    var images = listOf<Item>()
    var category = listOf<Category>()

    init {
        images = listOf(
            Item(1, "https://image.freepik.com/free-vector/mosquito-control-concept_23-2147946479.jpg"),
            Item(2, "https://image.freepik.com/free-vector/mosquito-control-concept_23-2147946479.jpg"),
            Item(3, "https://image.freepik.com/free-vector/mosquito-control-concept_23-2147946479.jpg"),
            Item(4, "https://image.freepik.com/free-vector/mosquito-control-concept_23-2147946479.jpg"),
            Item(5, "https://image.freepik.com/free-vector/mosquito-control-concept_23-2147946479.jpg")
        )
        category = listOf(
            Category(1, "Pest Control"),
            Category(2, "Kill Bugs"),
            Category(3, "Home Cleaning"),
            Category(4, "Washing"),
            Category(5, "Dummy data")
        )
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
