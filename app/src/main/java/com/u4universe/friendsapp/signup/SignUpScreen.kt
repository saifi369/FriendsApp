package com.u4universe.friendsapp.signup

import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.u4universe.friendsapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    device = "id:pixel_6",
    showBackground = true,
    showSystemUi = true
)
fun SignUpScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenTitle(R.string.signUpScreenTitle)

        Spacer(modifier = Modifier.height(16.dp))


        EmailField(email, onValueChange = { email = it })
        Spacer(modifier = Modifier.height(8.dp))
        PasswordField(password = password, onValueChange = { password = it })

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.submitButtonText))
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun EmailField(
    email: String, onValueChange: (String) -> Unit
) {
    TextField(
        modifier = Modifier.fillMaxWidth(), value = email, label = {
            Text(text = stringResource(id = R.string.emailHint))
        }, onValueChange = onValueChange
    )
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun PasswordField(
    password: String, onValueChange: (String) -> Unit
) {
    var isVisible by remember { mutableStateOf(false) }
    val visualTransformation = if (isVisible) {
        VisualTransformation.None
    } else {
        PasswordVisualTransformation()
    }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(stringResource(id = R.string.passwordHint)),
        trailingIcon = {
            TrailingIcon(
                isVisible = isVisible
            ) { isVisible = !isVisible }
        },
        visualTransformation = visualTransformation,
        value = password,
        label = {
            Text(text = stringResource(id = R.string.passwordHint))
        },
        onValueChange = onValueChange
    )
}

@Composable
private fun TrailingIcon(
    isVisible: Boolean,
    onToggle: () -> Unit
) {
    IconButton(onClick = onToggle) {
        val visibilityRes = if (isVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
        Icon(
            imageVector = visibilityRes,
            contentDescription = stringResource(id = R.string.toggleVisibility)
        )
    }
}

@Composable
private fun ScreenTitle(@StringRes screenTitle: Int) {
    Text(
        text = stringResource(id = screenTitle), style = typography.headlineMedium
    )
}