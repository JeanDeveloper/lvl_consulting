package com.jchunga.lvlapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jchunga.lvlapp.ui.theme.BlueAccent
import com.jchunga.lvlapp.ui.theme.Geologica
import com.jchunga.lvlapp.ui.theme.LighGray

@Composable
fun CustomTextField(
    modifier: Modifier,
    label: String,
    trailingIcon:@Composable()(() -> Unit)? = null,
    value: String,
    keyboardOptions: KeyboardOptions,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier.height(70.dp).fillMaxWidth(),
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
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        trailingIcon = trailingIcon,
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BlueAccent,
            unfocusedBorderColor = LighGray,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            cursorColor = BlueAccent
        ),
    )
}

class CustomVisualTransformation(private val maskChar: Char) : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val transformedText = AnnotatedString(maskChar.toString().repeat(text.length))
        return TransformedText(transformedText, OffsetMapping.Identity)
    }
}