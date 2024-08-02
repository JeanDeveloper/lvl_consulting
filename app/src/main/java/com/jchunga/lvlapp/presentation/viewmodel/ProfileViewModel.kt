package com.jchunga.lvlapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {

    private val _name = MutableStateFlow("")
    val name : StateFlow<String> = _name

    private val _surname = MutableStateFlow("")
    val surname : StateFlow<String> = _surname

    private val _enterprise = MutableStateFlow("")
    val enterprise : StateFlow<String> = _enterprise

    private val _charge = MutableStateFlow("")
    val charge : StateFlow<String> = _charge

    private val _phone = MutableStateFlow("")
    val phone : StateFlow<String> = _phone

    private val _email = MutableStateFlow("")
    val email : StateFlow<String> = _email

    fun onNameChanged(name:String){
        _name.value = name
    }

    fun onSurNameChanged(surname:String){
        _surname.value = surname
    }

    fun onEnterpriseChanged(enterprise:String){
        _enterprise.value = enterprise
    }

    fun onChargeChanged(charge:String){
        _charge.value = charge
    }

    fun onPhoneChanged(phone:String){
        _phone.value = phone
    }

    fun onEmailChanged(email:String){
        _email.value = email
    }

}