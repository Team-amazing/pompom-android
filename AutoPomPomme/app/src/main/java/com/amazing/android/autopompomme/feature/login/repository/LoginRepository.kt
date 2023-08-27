package com.amazing.android.autopompomme.feature.login.repository

import com.google.firebase.auth.FirebaseAuth

class LoginRepository(private val auth: FirebaseAuth) {

    fun login(email: String, password: String, callback: (Boolean) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                callback(task.isSuccessful)
            }
    }
}