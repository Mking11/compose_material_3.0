package com.mking11.compose.buttons

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import com.mking11.compose.buttons.utils.*
import java.util.*


/**
 * An Extension of the default Material button, which is also known as a Filled button
 *
 * The text style for ['TEXT'] components will be set to [Typography.labelLarge].
 *
 * @param onClick will be called when the user clicks the button.
 * @param modifier modifier to be applied to the button.
 * @param fullWidth controls whether the button would scale to full container size
 * @param emphasisLevel  level of emphasis of the button
 *                         [EmphasisLevel.Standard] default emphasis level
 *                         [EmphasisLevel.Destructive] button for deletion and warning
 *                         [EmphasisLevel.HighEmphasis] button for high emphasis interaction
 *                         com.mking11.compose.buttons.EmphasisLevel
 * @param enabled controls the enabled state of the button. When `false`, this button will not be
 * clickable.
 * @param paddingValues padding values with the parent container
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states
 * @param text text value of the button
 *
 */
@Composable
fun M3Button(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fullWidth: Boolean = false,
    emphasisLevel: EmphasisLevel = EmphasisLevel.Standard,
    enabled: Boolean = true,
    paddingValues: PaddingValues = ButtonDefaults.ContentPadding,
    text: String,
    testTag: String = ""
) {
    if (android12()) {
        Button(
            onClick = onClick,
            modifier = if (!fullWidth) modifier
                .testTag(testTag)
                .padding(paddingValues) else modifier
                .fillMaxWidth()
                .testTag(testTag)
                .padding(paddingValues),
            enabled = enabled,
            colors = getButtonColor12(emphasisLevel),
            shape = RoundedCornerShape(CornerRadius),
        ) {
            Text(text = text.uppercase(Locale.getDefault()), textAlign = TextAlign.Center)
        }
    } else {
        androidx.compose.material.Button(
            onClick = onClick,
            modifier = if (!fullWidth) modifier
                .testTag(testTag)
                .padding(paddingValues) else modifier
                .fillMaxWidth()
                .testTag(testTag)
                .padding(paddingValues),
            enabled = enabled,
            colors = getButtonColor(emphasisLevel),
            shape = RoundedCornerShape(CornerRadius),
        ) {
            androidx.compose.material.Text(
                text = text.uppercase(Locale.getDefault()),
                textAlign = TextAlign.Center,
                color = if (isSystemInDarkTheme()) MaterialTheme.colors.onPrimary else Color.Unspecified )
        }

    }

}
