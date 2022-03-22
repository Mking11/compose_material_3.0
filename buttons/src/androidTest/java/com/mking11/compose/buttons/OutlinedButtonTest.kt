package com.mking11.compose.buttons

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.mking11.compose.buttons.utils.TestTags
import org.junit.Rule
import org.junit.Test

class OutlinedButtonTest {

    private val uncapitalizedText = "Submit"
    private val capitalizedText = uncapitalizedText.uppercase()

    private val clicked = "Clicked"
    private val notClicked = "Not Clicked"

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun assertButtonExists() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    M3OutlinedButton(onClick = {
                    }, text = capitalizedText, testTag = TestTags.M3OutlinedButton)
                }
            }
        }

        composeTestRule.onNodeWithTag(TestTags.M3OutlinedButton).assertExists()
    }


    @Test
    fun assertButtonTextIsCapitalized() {

        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    M3OutlinedButton(onClick = {

                    }, text = uncapitalizedText, testTag = TestTags.M3OutlinedButton)
                }
            }
        }
        composeTestRule.onNodeWithTag(TestTags.M3OutlinedButton).assertTextContains(capitalizedText)
    }

    @Test
    fun assertButtonOnClickWorks() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    val (_clicked, setClicked) = remember { mutableStateOf(false) }
                    M3OutlinedButton(onClick = {
                        setClicked(true)
                    }, text = if (_clicked) clicked else notClicked, testTag = TestTags.M3OutlinedButton)
                }
            }
        }

        composeTestRule.onNodeWithTag(TestTags.M3OutlinedButton).performClick()
        composeTestRule.onNodeWithTag(TestTags.M3OutlinedButton).assertTextContains(clicked.uppercase())
    }

    @Test
    fun assertButtonEnabledWorks() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    val (_clicked, setClicked) = remember { mutableStateOf(false) }
                    M3OutlinedButton(
                        onClick = {
                            setClicked(true)

                        },
                        text = if (_clicked) clicked else notClicked,
                        enabled = true,
                        testTag = TestTags.M3OutlinedButton
                    )
                }
            }
        }

        composeTestRule.onNodeWithTag(TestTags.M3OutlinedButton).assertIsEnabled()

    }

    @Test
    fun assertButtonIsDisabled() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    val (_clicked, setClicked) = remember { mutableStateOf(false) }
                    M3OutlinedButton(
                        onClick = {
                            setClicked(true)
                        },
                        text = if (_clicked) clicked else notClicked,
                        enabled = false,
                        testTag = TestTags.M3OutlinedButton
                    )
                }
            }
        }

        composeTestRule.onNodeWithTag(TestTags.M3OutlinedButton).assertIsNotEnabled()

    }

    @Test
    fun assertButtonClickWontWorkIfDisabled() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    val (_clicked, setClicked) = remember { mutableStateOf(false) }
                    M3OutlinedButton(
                        onClick = {
                            setClicked(true)
                        },
                        text = if (_clicked) clicked else notClicked,
                        enabled = false,
                        testTag = TestTags.M3OutlinedButton
                    )
                }
            }
        }


        composeTestRule.onNodeWithTag(TestTags.M3OutlinedButton).apply {
            assertIsNotEnabled()
            performClick()
            assertTextEquals(notClicked.uppercase())
        }


    }


}