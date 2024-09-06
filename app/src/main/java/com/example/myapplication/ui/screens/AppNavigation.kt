package com.example.myapplication.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Welcome

@Composable
fun AppNavigation(
    loginViewModel: LoginViewModel,
    navController: NavHostController = rememberNavController(),
    ) {
    NavHost(
        navController = navController,
        startDestination = Login
        ) {
        composable<Login> {
            val uiState = loginViewModel.uiState.collectAsState().value
            LoginScreen(
                uiState = uiState,
                onNavigateToWelcome = {
                    navController.navigate(route = Welcome)
                })
        }
        composable<Welcome> {
            WelcomeScreen()
        }
    }
}