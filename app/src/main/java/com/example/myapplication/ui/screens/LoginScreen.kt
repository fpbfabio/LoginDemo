package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onNavigateToWelcome: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column {
            Spacer(modifier = Modifier.height(50.dp))
            Text("Login")
            TextField(uiState.login, uiState.onLoginValueChanged)
            Spacer(modifier = Modifier.height(10.dp))
            Text("Password")
            TextField(uiState.password, uiState.onPasswordChanged)
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { uiState.onLoginClick(onNavigateToWelcome) }) {
                Text("Login")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(uiState.feedbackText)
        }
    }
}