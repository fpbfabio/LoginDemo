package com.example.myapplication.ui.screens

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    companion object {
        private val VALID_LOGIN = "dummy@dummy.com"
        private val VALID_PASSWORD = "dummy"
    }

    val _uiState = MutableStateFlow(LoginUiState(
        login = "",
        password = "",
        onLoginValueChanged = { s -> onLoginValueChanged(s) },
        onPasswordChanged = { s -> onPasswordChanged(s) },
        onLoginClick = { goToWelcome -> doLogin(goToWelcome) }
    ))

    val uiState = _uiState.asStateFlow()

    private fun onPasswordChanged(s: String){
        _uiState.update { state -> state.copy(password = s) }
    }

    private fun onLoginValueChanged(s: String) {
        _uiState.update { state -> state.copy(login = s) }
    }

    private fun updateFeedbackText(s: String) {
        _uiState.update { state -> state.copy(feedbackText = s) }
    }

    private fun doLogin(goToWelcome : () -> Unit) {
        if (_uiState.value.login.isEmpty()) {
            updateFeedbackText("Please type your login")
            return
        }
        if (_uiState.value.password.isEmpty()) {
            updateFeedbackText("Please type your password")
            return
        }
        if (_uiState.value.login != VALID_LOGIN) {
            updateFeedbackText("User does not exist")
            return
        }
        if (_uiState.value.password != VALID_PASSWORD) {
            updateFeedbackText("Password is incorrect")
            return
        }
        goToWelcome()
    }
}