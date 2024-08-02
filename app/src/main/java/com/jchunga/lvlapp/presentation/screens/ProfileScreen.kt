package com.jchunga.lvlapp.presentation.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jchunga.lvlapp.presentation.components.CustomButton
import com.jchunga.lvlapp.presentation.components.CustomTextField
import com.jchunga.lvlapp.presentation.components.ProfileImage
import com.jchunga.lvlapp.presentation.navigation.localHomeNavController
import com.jchunga.lvlapp.presentation.viewmodel.ProfileViewModel
import com.jchunga.lvlapp.ui.theme.BackgroundColor
import com.jchunga.lvlapp.ui.theme.BlueAccent
import com.jchunga.lvlapp.ui.theme.Geologica
import com.jchunga.lvlapp.ui.theme.LighBlack

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    newProjectViewModel: ProfileViewModel = hiltViewModel()
){
    val navController = localHomeNavController.current
    Scaffold (
        containerColor = BackgroundColor,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = BackgroundColor
                ),
                title = {
                    Text(
                        "Mi Perfil",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontFamily = Geologica,
                            fontWeight = FontWeight.Medium,
                            color = LighBlack
                        )
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = null,
                            tint = BlueAccent
                        )
                    }
                }
            )
        },
    ){

        val name:String by newProjectViewModel.name.collectAsState( "" )
        val surname:String by newProjectViewModel.surname.collectAsState( "" )
        val enterprise:String by newProjectViewModel.enterprise.collectAsState( "" )
        val charge:String by newProjectViewModel.charge.collectAsState( "" )
        val phone:String by newProjectViewModel.phone.collectAsState( "" )
        val email:String by newProjectViewModel.email.collectAsState( "" )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .padding(20.dp)
        ){
            ProfileImage(
                imageUrl = "https://www.example.com/your-image-url.jpg",
                size = 100.dp
            )

            CustomTextField(
                modifier = Modifier.padding(vertical = 10.dp),
                label = "Nombres",
                value =  name,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                onValueChange = {
                    newProjectViewModel.onNameChanged(it)
                }
            )

            CustomTextField(
                modifier = Modifier.padding(vertical = 10.dp),
                label = "Apellidos",
                value =  surname,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                onValueChange = {
                    newProjectViewModel.onNameChanged(it)
                }
            )

            CustomTextField(
                modifier = Modifier.padding(vertical = 10.dp),
                label = "Nombre de la Empresa",
                value =  enterprise,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                onValueChange = {
                    newProjectViewModel.onNameChanged(it)
                }
            )

            CustomTextField(
                modifier = Modifier.padding(vertical = 10.dp),
                label = "Cargo en la Empresa",
                value =  charge,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                onValueChange = {
                    newProjectViewModel.onNameChanged(it)
                }
            )

            CustomTextField(
                modifier = Modifier.padding(vertical = 10.dp),
                label = "Telefono",
                value =  enterprise,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                onValueChange = {
                    newProjectViewModel.onNameChanged(it)
                }
            )

            CustomTextField(
                modifier = Modifier.padding(vertical = 10.dp),
                label = "Correo Eléctronico",
                value =  email,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                onValueChange = {
                    newProjectViewModel.onNameChanged(it)
                }
            )

            Spacer(modifier = Modifier.size(30.dp))

            CustomButton(
                text = "Guardar"
            )

        }

    }
}

@Preview
@Composable
fun PreviewProfileScreen(){
    ProfileScreen()
}