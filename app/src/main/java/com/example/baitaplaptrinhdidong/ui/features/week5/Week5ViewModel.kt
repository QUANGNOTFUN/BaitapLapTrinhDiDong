package com.example.baitaplaptrinhdidong.ui.features.week5

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.Firebase
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth

class Week5ViewModel : ViewModel() {

    fun handleGoogleSignIn(data: Intent?): Boolean {
        val task = GoogleSignIn.getSignedInAccountFromIntent(data)
        try {
            val account = task.getResult(ApiException::class.java)

            val idToken = account?.idToken
            if (idToken != null) {
                firebaseAuthWithGoogle(idToken)
                return true
            }
        } catch (e: Exception) {
            Log.w("AuthViewModel", "handleGoogleSignIn:failure", e)
        }

        return false
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        Firebase.auth.signInWithCredential(credential)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d("AuthViewModel", "signInWithCredential:success")
                } else {
                    Log.w("AuthViewModel", "signInWithCredential:failure", it.exception)
                }
            }
    }
}