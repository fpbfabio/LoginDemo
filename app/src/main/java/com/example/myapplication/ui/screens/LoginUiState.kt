package com.example.myapplication.ui.screens

data class LoginUiState(
    val login: String = "",
    val password: String = "",
    val onLoginValueChanged: (String) -> Unit = {},
    val onPasswordChanged: (String) -> Unit = {},
    val onLoginClick: (() -> Unit) -> Unit = {},
    val feedbackText: String = ""
)