package com.teckudos.goldenhicare.viewmodels

import androidx.lifecycle.ViewModel
import com.teckudos.goldenhicare.domain.CategoryItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class CategoryViewModel : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init{

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun getCategoryItem(): ArrayList<CategoryItem> {
        val categoryItem = arrayListOf<CategoryItem>()
        for (count in 0..10) {
            categoryItem.add(
                CategoryItem(
                    count,
                    "",
                    "Vikas Sharma",
                    "Teckudos Pvt Ltd",
                    "4",
                    "55%",
                    "9582296350",
                    "teckudos@gmail.com"
                )
            )
        }
        return categoryItem
    }
}
