package com.teckudos.goldenhicare.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    val phoneNumber = MutableLiveData<String>()

    val validate = Transformations.map(phoneNumber, ::isValidate)

    private fun isValidate(number: String) = number.length == 10

    private val _navigateToMain = MutableLiveData<Boolean>()
    val navigateToMain: LiveData<Boolean>
        get() = _navigateToMain

    fun onNavigateToMain() {
        _navigateToMain.value = true
    }
}
