package com.jchunga.lvlapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    private val _email = MutableStateFlow("")
    val email : StateFlow<String> = _email

    private val _password = MutableStateFlow("")
    val password : StateFlow<String> = _password

    private val _isLoginEnable = MutableStateFlow(true)
    val isLoginEnable: StateFlow<Boolean> = _isLoginEnable

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _passVisibility = MutableStateFlow(false)
    val passVisibility: StateFlow<Boolean> = _passVisibility

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState



    fun changePassVisibility(){
        _passVisibility.value = !(_passVisibility.value ?: false)
    }

    fun onLoginChanged(username:String, password: String){
        _email.value = username
        _password.value = password
        _isLoginEnable.value = enableLogin(username, password)
    }

    private fun enableLogin(username:String, password:String) = username.isNotBlank() && password.length > 4

    fun login() {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            delay(1000) // Simula una llamada de red
            if (_email.value == "admin@admin.com" && _password.value == "admin") {
                _loginState.value = LoginState.Success
            } else {
                _loginState.value = LoginState.Error("Credenciales incorrectas")
            }
        }
    }
}

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    object Success : LoginState()
    data class Error(val message: String) : LoginState()
}