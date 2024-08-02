package com.jchunga.lvlapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import coil.compose.rememberAsyncImagePainter
import com.jchunga.lvlapp.R

@Composable
fun CircleAvatar(
    imageUrl: String?,
    size: Dp,
    onClick:() -> Unit = {}
) {
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
                .clip(CircleShape)
                .clickable{ onClick() },
            contentScale = ContentScale.Crop
        )
    }
}