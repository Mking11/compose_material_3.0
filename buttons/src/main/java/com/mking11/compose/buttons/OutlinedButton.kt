package com.mking11.compose.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.mking11.compose.buttons.utils.CornerRadius
import com.mking11.compose.buttons.utils.android12
import java.util.*

/**
 * An Extension of the Outlined Material button, which is also known as a Filled button
 *
 * The text style for ['TEXT'] components will be set to [Typography.labelLarge].
 *
 * @param onClick will be called when the user clicks the button.
 * @param modifier modifier to be applied to the button.
 * @param fullWidth controls whether the button would scale to full container size
 * @param enabled controls the enabled state of the button. When `false`, this button will not be
 * clickable.
 * @param paddingValues padding values with the parent container
 * @param text text value of the button
 *
 */
@Composable
fun M3OutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    fullWidth: Boolean = false,
    enabled: Boolean = true,
    paddingValues: PaddingValues = ButtonDefaults.ContentPadding,
    text: String,
    testTag: String = ""
) {

    if (android12()) {
        OutlinedButton(
            onClick = onClick,
            modifier = if (!fullWidth) modifier
                .padding(paddingValues)
                .testTag(testTag) else modifier
                .fillMaxWidth()
                .testTag(testTag)
                .padding(paddingValues),
            enabled = enabled, shape = RoundedCornerShape(CornerRadius)
        ) {
            Text(text = text.uppercase(Locale.getDefault()))
        }
    } else {
        androidx.compose.material.OutlinedButton(
            onClick = onClick,
            modifier = if (!fullWidth) modifier
                .padding(paddingValues)
                .testTag(testTag) else modifier
                .fillMaxWidth()
                .testTag(testTag)
                .padding(paddingValues),
            enabled = enabled, shape = RoundedCornerShape(CornerRadius), border = BorderStroke(
                width = 0.5.dp,
                color = MaterialTheme.colors.primary,
            )
        ) {
            androidx.compose.material.Text(text = text.uppercase(Locale.getDefault()))
        }
    }

}
