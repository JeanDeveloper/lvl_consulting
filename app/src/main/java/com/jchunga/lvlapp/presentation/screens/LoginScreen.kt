package com.jchunga.lvlapp.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jchunga.lvlapp.R
import com.jchunga.lvlapp.presentation.components.CustomButton
import com.jchunga.lvlapp.presentation.components.CustomTextField
import com.jchunga.lvlapp.presentation.viewmodel.MainViewModel
import com.jchunga.lvlapp.ui.theme.BlueAccent
import com.jchunga.lvlapp.ui.theme.Geologica
import androidx.hilt.navigation.compose.hiltViewModel
import com.jchunga.lvlapp.core.Screen
import com.jchunga.lvlapp.presentation.components.CustomVisualTransformation
import com.jchunga.lvlapp.presentation.navigation.localHomeNavController
import com.jchunga.lvlapp.presentation.viewmodel.LoginState
import com.jchunga.lvlapp.ui.theme.BackgroundColor
import kotlinx.coroutines.launch
import okhttp3.Route

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel = hiltViewModel()
){

    val navController = localHomeNavController.current
    val email:String by mainViewModel.email.collectAsState(initial = "")
    val password:String by mainViewModel.password.collectAsState(initial = "")
    val isLoginEnable:Boolean by mainViewModel.isLoginEnable.collectAsState(initial = false)
    val isLoading:Boolean by mainViewModel.isLoading.collectAsState(initial = false)
    val passVisibility:Boolean  by mainViewModel.passVisibility.collectAsState( initial =false)
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val loginState by mainViewModel.loginState.collectAsState()
    val annotatedString = buildAnnotatedString {
        append("a ")
        withStyle(style = SpanStyle(color = BlueAccent)) {
            append("JIRA Atllassian")
        }
        append("!")
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState)},

        content = {
            Surface(
                color = BackgroundColor,
                modifier = modifier.fillMaxSize(),
            ){
                Column(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 17.dp, vertical = 50.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ){
                    Image(
                        painter = painterResource(id = R.drawable.logo_lvl),
                        contentDescription = "Logo Image",
                        modifier = modifier
                            .width(106.61.dp)
                            .height(80.dp)
                    )

                    Text(text = "¡Te damos la bienvenida!", style = TextStyle(fontFamily = Geologica, fontSize = 22.sp))

                    Text(text = annotatedString, style = TextStyle(fontFamily = Geologica, fontSize = 22.sp))

                    Text(text = "Hola, inicia sesión para continuar", style = TextStyle(fontFamily = Geologica, fontSize = 16.sp, color = Color.Gray))

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomTextField(
                        modifier = Modifier,
                        label = "Correo electrónico",
                        value =  email,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next
                        ),
                        onValueChange = {
                            mainViewModel.onLoginChanged(username = it, password = password)
                        }
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    CustomTextField(
                        modifier = Modifier,
                        label = "Contraseña",
                        value = password,
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Next
                        ),
                        visualTransformation = if(passVisibility) VisualTransformation.None
                        else CustomVisualTransformation('*'),
                        trailingIcon = {
                            val image = if(passVisibility){
                                Icons.Filled.Visibility
                            }else{
                                Icons.Filled.VisibilityOff
                            }
                            IconButton(
                                onClick = {
                                    mainViewModel.changePassVisibility()
                                }
                            ) {
                                Icon(
                                    image,
                                    contentDescription = null,
                                    tint = BlueAccent
                                )
                            }
                        },
                        onValueChange = {
                            mainViewModel.onLoginChanged(username = email, password = it)
                        },
                    )

                    Row(
                        modifier=modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        ForgotPassword()

                        TextButton(
                            onClick = {

                            }
                        ) {
                            Text(text = "Olvidé mi contraseña", style = TextStyle(fontFamily = Geologica, fontSize = 16.sp, color = BlueAccent))
                        }
                    }
                    Spacer(modifier = Modifier.height(70.dp))
                    CustomButton(
                        text = "Iniciar Sesion",
                        onClick = {
                            mainViewModel.login()
                        }
                    )

                }

            }

        }

    )
    when (loginState) {
        is LoginState.Loading -> {
            // Mostrar un indicador de carga si es necesario
        }
        is LoginState.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Login.route) { inclusive = true }
                }
            }
        }
        is LoginState.Error -> {
            val errorMessage = (loginState as LoginState.Error).message
            LaunchedEffect(snackbarHostState) {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(errorMessage)
                }
            }
        }
        else -> {}
    }


}

@Composable
fun ForgotPassword(){
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(
            checked = true,
            onCheckedChange = {},
            colors  = CheckboxDefaults.colors(
                checkedColor = BlueAccent
            )
        )
        Text(
            text = "Recordarme",
            style = TextStyle(fontFamily = Geologica, fontSize = 16.sp)
        )
    }
}

@Preview
@Composable
fun PreviewLoginScreen(){
    LoginScreen()
}
