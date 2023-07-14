package com.caperezh.stefaninichallenge.navigation

import android.annotation.SuppressLint

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.caperezh.stefaninichallenge.presentation.HomeView
import com.caperezh.stefaninichallenge.presentation.SplashView


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavigationScreen() {
    val navController = rememberNavController()
    Scaffold(
        content = {
            NavHost(
                navController = navController,
                startDestination = DestinationScreen.SplashScreenDest.route
            ) {
                composable(route = DestinationScreen.SplashScreenDest.route) {
                    SplashView(navController = navController)
                }

                composable(route = DestinationScreen.LoginScreenDest.route) {
                    HomeView()
                }
            }
        },
    )
}
