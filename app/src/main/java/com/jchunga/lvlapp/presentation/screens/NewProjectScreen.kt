package com.jchunga.lvlapp.presentation.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Autorenew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jchunga.lvlapp.core.IconProjects
import com.jchunga.lvlapp.domain.entities.IconProject
import com.jchunga.lvlapp.presentation.components.CustomButton
import com.jchunga.lvlapp.presentation.components.CustomDatePicker
import com.jchunga.lvlapp.presentation.components.CustomDropDownButton
import com.jchunga.lvlapp.presentation.components.CustomTextField
import com.jchunga.lvlapp.presentation.navigation.localHomeNavController
import com.jchunga.lvlapp.presentation.viewmodel.NewProjectViewModel
import com.jchunga.lvlapp.ui.theme.BackgroundColor
import com.jchunga.lvlapp.ui.theme.BlueAccent
import com.jchunga.lvlapp.ui.theme.Geologica
import com.jchunga.lvlapp.ui.theme.Gray
import com.jchunga.lvlapp.ui.theme.LighBlack
import com.jchunga.lvlapp.ui.theme.LighGray
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewProjectScreen(
    modifier: Modifier = Modifier,
    newProjectViewModel: NewProjectViewModel = hiltViewModel()
){
    val navController = localHomeNavController.current
    val iconSelected:IconProject by newProjectViewModel.iconSelected.collectAsState( initial = IconProjects.random() )
    val name:String by newProjectViewModel.nameProject.collectAsState( "" )
    val description:String by newProjectViewModel.descriptionProject.collectAsState( "" )
    val sharing:Boolean by newProjectViewModel.share.collectAsState( false )

    Scaffold(
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
                        "Nuevo Proyecto",
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
                            contentDescription = null
                        )
                    }
                }
            )
        },
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .padding(20.dp)
        ){
            Text(
                text = "Icono del Proyecto",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontFamily = Geologica,
                    color = LighBlack
                )
            )

            Spacer(modifier = Modifier.size(20.dp))

            Row (
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                ChooseIcon(  icon = iconSelected )

                Spacer(modifier = Modifier.size(50.dp))

                Text(
                    "Cambiar icono aleatorio",
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontFamily = Geologica,
                        fontWeight = FontWeight.Medium,
                        color = Gray
                    )
                )

                IconButton(
                    onClick = {
                        newProjectViewModel.changeRandomIcon()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Autorenew,
                        contentDescription = null,
                        tint = BlueAccent
                    )
                }

            }

            CustomTextField(
                modifier = Modifier.padding(vertical = 10.dp),
                label = "Nombre del Proyecto",
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
                label = "Descripción",
                value =  description,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                onValueChange = {
                    newProjectViewModel.onDescriptionChanged(it)
                }
            )

            CustomDropDownButton( modifier = Modifier.padding(vertical = 10.dp) )

            CustomDatePicker( modifier = Modifier.padding(vertical = 10.dp) )


            Row(
                modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    "¿Compartir con otros miembros? ",
                    style =  TextStyle(
                        fontFamily = Geologica,
                        color = Gray,
                        fontSize = 14.sp
                    )
                )
                Switch(
                    checked = sharing,
                    onCheckedChange = { value ->
                        newProjectViewModel.onSharedMemberChange(value)
                    }
                )
            }

            Spacer(modifier = Modifier.size(100.dp))

            CustomButton(text = "Crear Proyecto")

        }

    }

}

@Composable
fun ChooseIcon(
    modifier: Modifier = Modifier,
    icon: IconProject
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(60.dp)
            .background(Color.White, shape = RoundedCornerShape(15.dp))
            .border(1.dp, LighGray, shape = RoundedCornerShape(15.dp))
    ){
        Image(
            painter = painterResource(id = icon.image),
            contentDescription = null,
            modifier = Modifier.size(25.dp)
        )
    }

}


@Preview
@Composable
fun PreviewNewProjectScreen(){
    NewProjectScreen()
}