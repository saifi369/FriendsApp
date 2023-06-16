package com.u4universe.friendsapp.signup

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.u4universe.friendsapp.MainActivity
import com.u4universe.friendsapp.R

fun launchSignUpScreen(
    rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>,
    block: SignUpRobot.() -> Unit
): SignUpRobot {
    return SignUpRobot(rule).apply(block)
}

class SignUpRobot(
    private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {
    fun typeEmail(email: String) {
        val emailHintText = rule.activity.getString(R.string.emailHint)
        rule.onNodeWithText(emailHintText)
            .performTextInput(email)
    }

    fun typePassword(password: String) {
        val passwordHintText = rule.activity.getString(R.string.passwordHint)
        rule.onNodeWithTag(passwordHintText)
            .performTextInput(password)
    }

    fun submit() {
        val submitText = rule.activity.getString(R.string.submitButtonText)
        rule.onNodeWithText(submitText)
            .performClick()
    }

    infix fun verify(block: SignUpVerification.() -> Unit): SignUpVerification {
        return SignUpVerification(rule).apply(block)
    }

}

class SignUpVerification(private val rule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>) {
    fun timelineScreenIsPresent() {
        val timeline = rule.activity.getString(R.string.timeline)
        rule.onNodeWithText(timeline)
            .assertIsDisplayed()
    }

}
