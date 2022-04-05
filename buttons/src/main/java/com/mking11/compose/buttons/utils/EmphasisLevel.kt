package com.mking11.compose.buttons.utils

import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


// buttons emphasis level

enum class EmphasisLevel {
    Standard,
    HighEmphasis,
    Destructive
}


@Composable
fun getButtonColor12(emphasisLevel: EmphasisLevel) =

    when (emphasisLevel) {
        EmphasisLevel.Standard -> ButtonDefaults.buttonColors()
        EmphasisLevel.HighEmphasis -> ButtonDefaults.buttonColors(
            containerColor = LightPink,
            contentColor = Color.White
        )
        EmphasisLevel.Destructive -> ButtonDefaults.buttonColors(
            containerColor = RedLight,
            contentColor = Color.White
        )
    }

@Composable
fun getButtonColor(emphasisLevel: EmphasisLevel) =

    when (emphasisLevel) {
        EmphasisLevel.Standard -> androidx.compose.material.ButtonDefaults.buttonColors()
        EmphasisLevel.HighEmphasis -> androidx.compose.material.ButtonDefaults.buttonColors(
            backgroundColor = LightPink,
            contentColor = Color.White
        )
        EmphasisLevel.Destructive -> androidx.compose.material.ButtonDefaults.buttonColors(
            contentColor = Color.White,
            backgroundColor = RedLight
        )
    }

