package com.jchunga.lvlapp.presentation.components


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jchunga.lvlapp.ui.theme.BlueAccent
import com.jchunga.lvlapp.ui.theme.Geologica


@Composable
fun CustomButton(
    text:String,
    onClick: () -> Unit = {}
){
    //Button
    FilledTonalButton(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .height(60.dp),
//            .clip(RoundedCornerShape(12.dp)),
        colors = ButtonDefaults.buttonColors( containerColor = BlueAccent ),
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 23.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontFamily = Geologica
            )
        )
    }

}