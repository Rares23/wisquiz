package com.crxapplications.wisquiz.ui.theme

import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

fun Color.withOpacity(opacity: Float): Color {
    val finOpacity = if (opacity < 0) 0f else if (opacity > 1) 1f else opacity
    return Color(red = red, green = green, blue = blue, alpha = finOpacity)
}