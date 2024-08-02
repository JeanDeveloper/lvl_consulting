package com.jchunga.lvlapp.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jchunga.lvlapp.R
import com.jchunga.lvlapp.core.Screen
import com.jchunga.lvlapp.presentation.navigation.localHomeNavController
import com.jchunga.lvlapp.ui.theme.BackgroundColor
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
){
    val navController = localHomeNavController.current
    Surface (
        color = BackgroundColor,
        modifier = modifier.fillMaxSize(),
    ){
        // Aquí puedes poner tu logo o cualquier contenido del splash screen
        LaunchedEffect(Unit) {
            delay(3000) // Espera 3 segundos
            navController.navigate(Screen.Login.route) {
                popUpTo("splash") { inclusive = true }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.logo_lvl),
            contentDescription = "Logo Image",
            modifier = modifier.width(130.dp).height(120.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen(){
    SplashScreen()
}