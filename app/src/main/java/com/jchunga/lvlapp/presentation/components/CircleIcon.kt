package com.jchunga.lvlapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jchunga.lvlapp.R
import com.jchunga.lvlapp.ui.theme.LighBlue
import com.jchunga.lvlapp.ui.theme.LighGray

@Composable
fun CircleIcon(
    modifier: Modifier = Modifier,
    image: Int,
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(60.dp)
            .clip(CircleShape)
            .background(LighBlue)
    ){
        IconButton(
            modifier = Modifier.align(Alignment.Center) ,
            onClick = { /*TODO*/ }
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.size(25.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCircleIcon(){
    CircleIcon(image = R.drawable.ic_folder)
}