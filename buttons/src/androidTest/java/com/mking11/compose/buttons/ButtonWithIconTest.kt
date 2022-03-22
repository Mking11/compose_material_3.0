package com.mking11.compose.buttons

import android.graphics.drawable.Drawable
import androidx.compose.material3.Icon
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.mking11.compose.buttons.utils.IconPlacing
import com.mking11.compose.buttons.utils.TestTags
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ButtonWithIconTest {

    private val uncapitalizedText = "Submit"
    private val capitalizedText = uncapitalizedText.uppercase()

    private val clicked = "Clicked"
    private val notClicked = "Not Clicked"
    private val drawable: Drawable? = null

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun assertButtonExists() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    M3ButtonWithIcon(
                        onClick = {
                        },
                        text = capitalizedText,
                        testTag = TestTags.M3ButtonWithIcon,
                        iconPlacing = IconPlacing.Leading
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                            contentDescription = "Down Icon"
                        )
                    }
                }
            }
        }

        composeTestRule.onNodeWithTag(TestTags.M3ButtonWithIcon).assertExists()
    }


    @Test
    fun assertButtonTextIsCapitalized() {

        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    M3ButtonWithIcon(
                        onClick = {

                        },
                        text = uncapitalizedText,
                        testTag = TestTags.M3ButtonWithIcon,
                        iconPlacing = IconPlacing.Leading
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                            contentDescription = "Down Icon"
                        )
                    }
                }
            }
        }
        composeTestRule.onNodeWithTag(TestTags.M3ButtonWithIcon).assertTextContains(capitalizedText)
    }

    @Test
    fun assertButtonOnClickWorks() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    val (_clicked, setClicked) = remember { mutableStateOf(false) }
                    M3ButtonWithIcon(
                        onClick = {
                            setClicked(true)
                        },
                        text = if (_clicked) clicked else notClicked,
                        testTag = TestTags.M3ButtonWithIcon,
                        iconPlacing = IconPlacing.Leading
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                            contentDescription = "Down Icon"
                        )
                    }
                }
            }
        }

        composeTestRule.onNodeWithTag(TestTags.M3ButtonWithIcon).performClick()
        composeTestRule.onNodeWithTag(TestTags.M3ButtonWithIcon)
            .assertTextContains(clicked.uppercase())
    }

    @Test
    fun assertButtonEnabledWorks() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    val (_clicked, setClicked) = remember { mutableStateOf(false) }
                    M3ButtonWithIcon(
                        onClick = {
                            setClicked(true)

                        },
                        text = if (_clicked) clicked else notClicked,
                        enabled = true,
                        testTag = TestTags.M3ButtonWithIcon, iconPlacing = IconPlacing.Leading
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                            contentDescription = "Down Icon"
                        )
                    }
                }
            }
        }

        composeTestRule.onNodeWithTag(TestTags.M3ButtonWithIcon).assertIsEnabled()

    }

    @Test
    fun assertButtonIsDisabled() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    val (_clicked, setClicked) = remember { mutableStateOf(false) }
                    M3ButtonWithIcon(
                        onClick = {
                            setClicked(true)
                        },
                        text = if (_clicked) clicked else notClicked,
                        enabled = false,
                        testTag = TestTags.M3ButtonWithIcon, iconPlacing = IconPlacing.Leading
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                            contentDescription = "Down Icon"
                        )
                    }
                }
            }
        }

        composeTestRule.onNodeWithTag(TestTags.M3ButtonWithIcon).assertIsNotEnabled()

    }

    @Test
    fun assertButtonClickWontWorkIfDisabled() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    val (_clicked, setClicked) = remember { mutableStateOf(false) }
                    M3ButtonWithIcon(
                        onClick = {
                            setClicked(true)
                        },
                        text = if (_clicked) clicked else notClicked,
                        enabled = false,
                        testTag = TestTags.M3ButtonWithIcon, iconPlacing = IconPlacing.Leading
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_down_24),
                            contentDescription = "Down Icon"
                        )
                    }
                }
            }
        }


        composeTestRule.onNodeWithTag(TestTags.M3ButtonWithIcon).apply {
            assertIsNotEnabled()
            performClick()
            assertTextEquals(notClicked.uppercase())
        }


    }


}