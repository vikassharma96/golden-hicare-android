package com.teckudos.goldenhicare.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.teckudos.goldenhicare.domain.CategoryItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class CategoryDetailViewModel : ViewModel() {

    private val viewModelJob = SupervisorJob()
    private val viewModelScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> get() = _count

    init {
        _count.value = 0
    }

    fun addToCart() {
        _count.value = _count.value?.plus(1)
    }

    fun plusOne() {
        _count.value = _count.value?.plus(1)
    }

    fun minusOne() {
        if (_count.value == 0) {
            return
        }
        _count.value = _count.value?.minus(1)
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
