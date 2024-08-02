package com.jchunga.lvlapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jchunga.lvlapp.ui.theme.BlueAccent
import com.jchunga.lvlapp.ui.theme.Geologica
import com.jchunga.lvlapp.ui.theme.LighGray

@Composable
fun CustomSearch(
    modifier : Modifier,
    label: String,
    leadingIcon: @Composable()(() -> Unit)? = null,
    trailingIcon: @Composable() (() -> Unit)? = null,
    value: String,
    keyboardOptions: KeyboardOptions,
    onValueChange: (String) -> Unit
){
    OutlinedTextField(
        modifier = modifier
            .padding(horizontal=20.dp)
            .height(70.dp)
            .fillMaxWidth(),
        value = value,
        onValueChange = { onValueChange(it) },
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = Geologica,
                    color = BlueAccent
                )
            )
        },
        singleLine = true,
        shape = RoundedCornerShape(12.dp),
        keyboardOptions = keyboardOptions,
        trailingIcon = trailingIcon,
        leadingIcon = leadingIcon,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BlueAccent,
            unfocusedBorderColor = LighGray,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            cursorColor = BlueAccent
        ),
    )




}