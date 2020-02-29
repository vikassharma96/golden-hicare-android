package com.teckudos.goldenhicare.views

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val changeGraph = MutableLiveData<Boolean>()
    
    init {
        changeGraph.value = false
    }

}