package com.jchunga.lvlapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jchunga.lvlapp.R


val Geologica = FontFamily(
    fonts = listOf(
        Font(R.font.geologica_extra_light, FontWeight.ExtraLight),
        Font(R.font.geologica_regular, FontWeight.Normal),
        Font(R.font.geologica_light, FontWeight.Light),
        Font(R.font.geologica_medium, FontWeight.Medium),
        Font(R.font.geologica_semi_bold, FontWeight.SemiBold),
        Font(R.font.geologica_bold, FontWeight.Bold),
        Font(R.font.geologica_extra_bold, FontWeight.ExtraBold)
    )
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)