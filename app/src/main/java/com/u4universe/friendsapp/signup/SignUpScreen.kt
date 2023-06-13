package com.u4universe.friendsapp.signup

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.u4universe.friendsapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(
  uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
  device = "id:pixel_6", showBackground = true, showSystemUi = true
)
fun SignUpScreen() {

  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(16.dp)
  ) {
    Text(text = stringResource(id = R.string.signUpScreenTitle),
      style = typo
    )

    TextField(
      value = "",
      label = {
        Text(text = stringResource(id = R.string.emailHint))
      },
      onValueChange = {}
    )

    TextField(
      value = "",
      label = {
        Text(text = stringResource(id = R.string.passwordHint))
      },
      onValueChange = {}
    )

    Button(onClick = { /*TODO*/ }) {
      Text(text = stringResource(id = R.string.submitButtonText))
    }
  }
}