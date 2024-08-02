package com.jchunga.lvlapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.jchunga.lvlapp.presentation.navigation.Navigation
import com.jchunga.lvlapp.presentation.screens.LoginScreen
import com.jchunga.lvlapp.presentation.screens.NewProjectScreen

import com.jchunga.lvlapp.ui.theme.LvlAppTheme
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LvlAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    LoginScreen()
//                    HomeScreen()
//                    NewProjectScreen()
                    Navigation()
                }
            }
        }
    }
}
