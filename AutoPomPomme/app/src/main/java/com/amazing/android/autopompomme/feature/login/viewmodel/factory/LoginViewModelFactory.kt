package com.amazing.android.autopompomme.feature.login.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.amazing.android.autopompomme.feature.login.repository.LoginRepository
import com.amazing.android.autopompomme.feature.login.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModelFactory(private val repository: LoginRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")
    }
}