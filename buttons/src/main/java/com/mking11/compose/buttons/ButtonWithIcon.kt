package com.mking11.compose.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.mking11.compose.buttons.utils.*
import java.util.*

/**
 * An extension of the default Material button with the addition of trailing and leading icon , which is also known as a Filled button
 *
 * The text style for ['TEXT'] components will be set to [Typography.labelLarge].
 *
 * @param onClick will be called when the user clicks the button.
 * @param modifier modifier to be applied to the button.
 * @param emphasisLevel  level of emphasis of the button
 *                         [EmphasisLevel.Standard] default emphasis level
 *                         [EmphasisLevel.Destructive] button for deletion and warning
 *                         [EmphasisLevel.HighEmphasis] button for high emphasis interaction
 *                         com.mking11.compose.buttons.EmphasisLevel
 * @param enabled controls the enabled state of the button. When `false`, this button will not be
 * clickable.
 * @param iconPlacing controls the placement of the icons
 *                  [IconPlacing.Leading] -> for leading icons
 *                  [IconPlacing.Trailing] -> for trailing icons
 *
 * @param paddingValues padding values with the parent container
 * @param text text value of the button
 * @param icon a composable icon content
 */
@Composable
fun M3ButtonWithIcon(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    iconPlacing: IconPlacing,
    paddingValues: PaddingValues = ButtonDefaults.ContentPadding,
    text: String,
    testTag: String = "",
    icon: @Composable (() -> Unit)
) {

    Button(
        onClick = onClick,
        modifier = modifier
            .padding(paddingValues).testTag(testTag),
        enabled = enabled,
        shape = RoundedCornerShape(CornerRadius), contentPadding = PaddingValues(6.dp, 6.dp)
    ) {

        ConstraintLayout {
            val (text_ref, icon_ref) = createRefs()

            Box(modifier = Modifier.constrainAs(icon_ref) {
                linkTo(parent.top, parent.bottom)
                when (iconPlacing) {
                    IconPlacing.Leading -> {
                        start.linkTo(parent.start, 0.dp)
                        end.linkTo(text_ref.start)

                    }
                    IconPlacing.Trailing -> {
                        start.linkTo(text_ref.end, 4.dp)
                        end.linkTo(parent.end, 0.dp)

                    }
                }

            }
            ) {

                icon()

            }


            Text(
                text = text.uppercase(Locale.getDefault()),
                modifier = Modifier.constrainAs(text_ref) {
                    linkTo(parent.top, parent.bottom)
                    when (iconPlacing) {
                        IconPlacing.Leading -> {
                            start.linkTo(icon_ref.end, 4.dp)
                            end.linkTo(
                                parent
                                    .end, 2.dp
                            )
                        }
                        IconPlacing.Trailing -> {
                            start.linkTo(parent.start, 8.dp)
                            end.linkTo(icon_ref.start)
                        }
                    }
                },
            )
        }
    }
}


