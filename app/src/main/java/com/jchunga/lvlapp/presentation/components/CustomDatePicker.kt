package com.jchunga.lvlapp.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jchunga.lvlapp.presentation.viewmodel.NewProjectViewModel
import com.jchunga.lvlapp.ui.theme.BlueAccent
import com.jchunga.lvlapp.ui.theme.Geologica
import com.jchunga.lvlapp.ui.theme.LighGray
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(
    modifier : Modifier,
    newProjectViewModel: NewProjectViewModel = hiltViewModel(),

){
    var showDialog by rememberSaveable { mutableStateOf(false) }
    val state = rememberDatePickerState()
    val date = state.selectedDateMillis
    var localDate: LocalDate = LocalDate.now()

    date?.let {
        localDate = Instant.ofEpochMilli(it).atZone(ZoneId.of("UTC")).toLocalDate()
    }

    Box{
        OutlinedTextField(
            modifier = modifier
                .height(70.dp)
                .fillMaxWidth()
                .clickable { showDialog = true },
            value = "${localDate.dayOfMonth}/${localDate.monthValue}/${localDate.year}" ?: "Fecha de Inicio",
            onValueChange = {},
            enabled = false,
            label = {
                Text(
                    text = "Fecha de Inicio",
                    style = TextStyle(
                        fontSize = 18.sp,
                        fontFamily = Geologica,
                        color = BlueAccent
                    )
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.CalendarToday,
                    contentDescription = null,
                    modifier.clickable {  showDialog = !showDialog },
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

        if( showDialog ) {
            DatePickerDialog(
                onDismissRequest = { showDialog = false },
                dismissButton = {
                    OutlinedButton(
                        onClick = { showDialog = false }
                    ){
                        Text(text = "Cancelar")
                    }
                },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                        }
                    ){
                        Text(text = "Confirmar")
                    }
                }
            ) {
                DatePicker( state = state )
            }
        }

    }

}