package com.mking11.compose.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.mking11.compose.buttons.utils.CornerRadius
import com.mking11.compose.buttons.utils.android12
import java.util.*

/**
 * An Extension of the default Material text button, which is also known as a Filled button
 *
 * The text style for ['TEXT'] components will be set to [Typography.labelLarge].
 *
 * @param onClick will be called when the user clicks the button.
 * @param modifier modifier to be applied to the button.
 * @param enabled controls the enabled state of the button. When `false`, this button will not be
 * clickable.
 * @param paddingValues padding values with the parent container
 * @param text text value of the button
 *
 */

@Composable
fun M3TextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    paddingValues: PaddingValues = ButtonDefaults.ContentPadding,
    text: String,
    testTag: String = ""
) {

    if (android12()) {
        TextButton(
            onClick = onClick,
            modifier = modifier
                .padding(paddingValues)
                .testTag(testTag),
            enabled = enabled, shape = RoundedCornerShape(CornerRadius)
        ) {
            Text(text = text.uppercase(Locale.getDefault()))
        }
    } else {
        androidx.compose.material.TextButton(
            onClick = onClick,
            modifier = modifier
                .padding(paddingValues)
                .testTag(testTag),
            enabled = enabled, shape = RoundedCornerShape(CornerRadius)
        ) {
            androidx.compose.material.Text(text = text.uppercase(Locale.getDefault()))
        }
    }


}
