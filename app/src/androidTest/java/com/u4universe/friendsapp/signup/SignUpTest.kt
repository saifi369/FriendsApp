package com.u4universe.friendsapp.signup

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.u4universe.friendsapp.MainActivity
import org.junit.Rule
import org.junit.Test

class SignUpTest {

  @get:Rule
  val signUpTestRule = createAndroidComposeRule<MainActivity>()

  @Test
  fun performSignUp() {
    launchSignUpScreen(signUpTestRule) {
      typeEmail("test@email.com")
      typePassword("password")
      submit()
    } verify {
      timelineScreenIsPresent()
    }
  }
}