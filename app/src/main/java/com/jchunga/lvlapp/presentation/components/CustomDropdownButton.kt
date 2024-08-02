package com.jchunga.lvlapp.presentation.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jchunga.lvlapp.core.ProjectStates
import com.jchunga.lvlapp.domain.entities.ProjectState
import com.jchunga.lvlapp.presentation.viewmodel.NewProjectViewModel
import com.jchunga.lvlapp.ui.theme.BlueAccent
import com.jchunga.lvlapp.ui.theme.Geologica
import com.jchunga.lvlapp.ui.theme.Gray
import com.jchunga.lvlapp.ui.theme.LighGray

@Composable
fun CustomDropDownButton(
    newProjectViewModel: NewProjectViewModel = hiltViewModel(),
    modifier:Modifier
){
    var expanded by remember { mutableStateOf(false) }
    val stateSelected: ProjectState? by newProjectViewModel.stateSelected.collectAsState( initial = ProjectStates[0] )

    Box {
        OutlinedTextField(
            modifier = modifier
                .height(70.dp)
                .fillMaxWidth()
                .clickable { expanded = true },
            value = if(stateSelected != null) stateSelected!!.name else ("Estado del Proyecto") ,
            onValueChange = {},
            enabled = false,
            label = {
                Text(
                    text = "Estado del Proyecto",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = Geologica,
                        color = BlueAccent
                    )
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = if (expanded) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
                    contentDescription = null,
                    modifier.clickable { expanded = !expanded },
                    tint = BlueAccent
                )
            },
            readOnly = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = BlueAccent,
                unfocusedBorderColor = LighGray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                cursorColor = BlueAccent
            )
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = modifier.fillMaxWidth()

        ) {
            ProjectStates.forEach { state ->
                DropdownMenuItem(
                    onClick = {
                        newProjectViewModel.onStateChanged(state)
                        expanded = false
                    },
                    text = {
                        Text(text = state.name, style =  TextStyle( color = Gray, fontSize = 14.sp ))
                    }
                )
            }
        }
    }
}