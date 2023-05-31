package com.example.ukl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommunicationViewModel: ViewModel() {
    private val mName = MutableLiveData<String>()
    private val mEmail = MutableLiveData<String>()
    private val mPassword = MutableLiveData<String>()

    val name: LiveData<String>
        get() = mName
    fun setName(name: String){
        mName.value = name
    }

    val email: LiveData<String>
        get() = mEmail
    fun setEmail(email: String){
        mEmail.value = email
    }

    val password: LiveData<String>
        get() = mPassword
    fun setPassword(pass: String){
        mPassword.value = pass
    }
}