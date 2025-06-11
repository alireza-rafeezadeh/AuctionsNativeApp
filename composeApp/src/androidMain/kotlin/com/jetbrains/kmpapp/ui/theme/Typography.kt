package com.jetbrains.kmpapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
// TODO: Use this or remove this
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp, // Your original FontSizeMedium
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleMedium = TextStyle( // Used for item.name in your AuctionListItem
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold, // Already bold in your original code
        fontSize = 18.sp, // Your original FontSizeLarge
        lineHeight = 24.sp,
        letterSpacing = 0.sp
    ),
    bodySmall = TextStyle( // Used for End Date, Municipality, Make, Description, Reserve Price
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp, // Your original FontSizeSmall
        lineHeight = 20.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle( // Could be used for small titles, e.g., "Current Bid:"
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    // ... other typography styles like headlineLarge, displaySmall, labelMedium, etc.
)