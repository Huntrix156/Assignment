package com.example.smartmedicalsystem.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


@Composable
    fun AppNavHost(navController: NavHostController= rememberNavController(),
                   startDestination:String = ROUTE_DASHBOARD){
        NavHost(navController = navController,
            startDestination = startDestination){
            composable(ROUTE_REGISTER) {RegisterScreen(navController)}

            composable(ROUTE_LOGIN ) {LoginScreen(navController) }

        }
    }