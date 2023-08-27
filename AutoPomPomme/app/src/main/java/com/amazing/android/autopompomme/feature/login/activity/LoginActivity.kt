package com.amazing.android.autopompomme.feature.login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.amazing.android.autopompomme.databinding.ActivityLoginBinding
import com.amazing.android.autopompomme.feature.login.repository.LoginRepository
import com.amazing.android.autopompomme.feature.login.viewmodel.LoginViewModel
import com.amazing.android.autopompomme.feature.login.viewmodel.factory.LoginViewModelFactory
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val repository = LoginRepository(auth)
        val factory = LoginViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)

        binding.btnLoginLogin.setOnClickListener {
            val email = binding.etLoginId.text.toString()
            val password = binding.etLoginPassword.text.toString()
            if (binding.etLoginId.length() > 0 || binding.etLoginPassword.length() > 0) {
                binding.btnLoginLogin.isEnabled = true

            }
            viewModel.login(email, password)

        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.loginResult.observe(this) { result ->
            if (result) {
                //로그인 성공
            } else {
                //로그인 실패
            }
        }
    }
}

