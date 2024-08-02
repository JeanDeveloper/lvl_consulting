package com.jchunga.lvlapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.jchunga.lvlapp.R
import com.jchunga.lvlapp.ui.theme.BlueAccent

@Composable
fun ProfileImage(
    imageUrl: String?,
    size: Dp,
    onClick: () -> Unit = {}
){

    Box(
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .background(Color.Gray)
    ) {
        Image(
            painter = painterResource(id = R.drawable.avatar_image),
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(size)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .size(30.dp)
                .clip(CircleShape)
                .background(Color.White)
                .align(Alignment.BottomEnd)
                .clickable { onClick() }
        ){
            Icon(
                modifier = Modifier.align(Alignment.Center).size(17.dp),
                imageVector = Icons.Outlined.Edit  ,
                contentDescription = null,
                tint = BlueAccent,

                )
        }
    }


}

@Preview
@Composable
fun PreviewProfileImage(){
    ProfileImage(
        imageUrl = "https://www.example.com/your-image-url.jpg",
        size = 60.dp
    )
}