package com.u4universe.friendsapp.signup

import com.u4universe.friendsapp.signup.state.SignUpState
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CredentialsValidationTest {
    @Test
    fun invalidEmail() {

        val viewModel = SignUpViewModel()
        viewModel.createAccount("email", ":password:", ":about:")

        assertEquals(SignUpState.BadEmail, viewModel.signUpState.value);
    }
}