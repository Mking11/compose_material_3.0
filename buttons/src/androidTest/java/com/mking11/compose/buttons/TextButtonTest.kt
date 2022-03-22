package com.mking11.compose.buttons

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.mking11.compose.buttons.utils.TestTags
import org.junit.Rule
import org.junit.Test

class TextButtonTest {

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
                    M3TextButton(onClick = {
                    }, text = capitalizedText, testTag = TestTags.M3TextButton)
                }
            }
        }

        composeTestRule.onNodeWithTag(TestTags.M3TextButton).assertExists()
    }


    @Test
    fun assertButtonTextIsCapitalized() {

        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    M3TextButton(onClick = {

                    }, text = uncapitalizedText, testTag = TestTags.M3TextButton)
                }
            }
        }
        composeTestRule.onNodeWithTag(TestTags.M3TextButton).assertTextContains(capitalizedText)
    }

    @Test
    fun assertButtonOnClickWorks() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    val (_clicked, setClicked) = remember { mutableStateOf(false) }
                    M3TextButton(onClick = {
                        setClicked(true)
                    }, text = if (_clicked) clicked else notClicked, testTag = TestTags.M3TextButton)
                }
            }
        }

        composeTestRule.onNodeWithTag(TestTags.M3TextButton).performClick()
        composeTestRule.onNodeWithTag(TestTags.M3TextButton).assertTextContains(clicked.uppercase())
    }

    @Test
    fun assertButtonEnabledWorks() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    val (_clicked, setClicked) = remember { mutableStateOf(false) }
                    M3TextButton(
                        onClick = {
                            setClicked(true)

                        },
                        text = if (_clicked) clicked else notClicked,
                        enabled = true,
                        testTag = TestTags.M3TextButton
                    )
                }
            }
        }

        composeTestRule.onNodeWithTag(TestTags.M3TextButton).assertIsEnabled()

    }

    @Test
    fun assertButtonIsDisabled() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    val (_clicked, setClicked) = remember { mutableStateOf(false) }
                    M3TextButton(
                        onClick = {
                            setClicked(true)
                        },
                        text = if (_clicked) clicked else notClicked,
                        enabled = false,
                        testTag = TestTags.M3TextButton
                    )
                }
            }
        }

        composeTestRule.onNodeWithTag(TestTags.M3TextButton).assertIsNotEnabled()

    }

    @Test
    fun assertButtonClickWontWorkIfDisabled() {
        composeTestRule.setContent {
            ComposeMaterialTestTheme {
                StandardButtonTestScreen {
                    val (_clicked, setClicked) = remember { mutableStateOf(false) }
                    M3TextButton(
                        onClick = {
                            setClicked(true)
                        },
                        text = if (_clicked) clicked else notClicked,
                        enabled = false,
                        testTag = TestTags.M3TextButton
                    )
                }
            }
        }


        composeTestRule.onNodeWithTag(TestTags.M3TextButton).apply {
            assertIsNotEnabled()
            performClick()
            assertTextEquals(notClicked.uppercase())
        }


    }


}