package com.amazing.android.autopompomme.feature.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amazing.android.autopompomme.feature.login.repository.LoginRepository

class LoginViewModel(private val repository: LoginRepository) : ViewModel() {

    val loginResult: MutableLiveData<Boolean> = MutableLiveData()

    fun login(email: String, password: String) {
        repository.login(email, password) { isSuccess ->
            loginResult.postValue(isSuccess)
        }

    }
}