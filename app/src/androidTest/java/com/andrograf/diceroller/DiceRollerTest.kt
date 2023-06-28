package com.andrograf.diceroller

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class DiceRollerTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun diceWithButtonAndImageTest(){
        composeTestRule.setContent {
            DiceWithButtonAndImage()
        }

    }
}