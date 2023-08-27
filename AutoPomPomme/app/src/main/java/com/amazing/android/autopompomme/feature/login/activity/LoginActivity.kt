package com.amazing.android.autopompomme.feature.login.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.amazing.android.autopompomme.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private var mBinding: ActivityLoginBinding? = null
    private val binding get() = mBinding!!
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        binding.btnLoginLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        if (binding.etLoginId.length() > 0 || binding.etLoginPassword.length() > 0) {
            binding.btnLoginLogin.isEnabled = true
            sever()
        }

    }

    private fun sever() {
        val email = binding.etLoginId
        val password = binding.etLoginPassword

        auth.signInWithEmailAndPassword(email.toString(), password.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val user = auth.currentUser
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                    //updateUI(null)
                }
            }
    }

    override fun onDestroy() {
        super.onDestroy()

        mBinding = null
    }
}

