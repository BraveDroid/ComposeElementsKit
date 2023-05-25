package com.mobilez.elementskit.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mobilez.compose.elementskit.R

private val fontFamilyKulim = FontFamily(
    listOf(
        Font(
            resId = R.font.kulim_park_regular,
        ),
        Font(
            resId = R.font.kulim_park_light,
            weight = FontWeight.Light,
        ),
    ),
)

private val fontFamilyLato = FontFamily(
    listOf(
        Font(
            resId = R.font.lato_regular,
        ),
        Font(
            resId = R.font.lato_bold,
            weight = FontWeight.Bold,
        ),
    ),
)

val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = fontFamilyKulim,
        fontWeight = FontWeight.Light,
        fontSize = 28.sp,
        letterSpacing = (1.15).sp,
    ),
    displayMedium = TextStyle(
        fontFamily = fontFamilyKulim,
        fontSize = 15.sp,
        letterSpacing = (1.15).sp,
    ),
    displaySmall = TextStyle(
        fontFamily = fontFamilyLato,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = fontFamilyLato,
        fontSize = 14.sp,
        letterSpacing = 0.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = fontFamilyLato,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = (1.15).sp,
    ),
    bodySmall = TextStyle(
        fontFamily = fontFamilyKulim,
        fontSize = 12.sp,
        letterSpacing = (1.15).sp,
    ),
)
