package com.jchunga.lvlapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jchunga.lvlapp.core.Screen
import com.jchunga.lvlapp.presentation.screens.HomeScreen
import com.jchunga.lvlapp.presentation.screens.LoginScreen
import com.jchunga.lvlapp.presentation.screens.NewProjectScreen
import com.jchunga.lvlapp.presentation.screens.ProfileScreen
import com.jchunga.lvlapp.presentation.screens.SplashScreen

val localHomeNavController = compositionLocalOf<NavController> { error("HomeNavcontroller") }

@Composable
fun Navigation() {
    val navController = rememberNavController()
    CompositionLocalProvider(value = localHomeNavController provides navController) {
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route
        ) {
            composable(Screen.Login.route){
                LoginScreen()
            }
            composable(Screen.Home.route){
                HomeScreen()
            }
            composable(Screen.Splash.route){
                SplashScreen()
            }
            composable(Screen.Profile.route){
                ProfileScreen()
            }
            composable(Screen.NewProject.route) {
                NewProjectScreen()
            }
        }
    }

}
