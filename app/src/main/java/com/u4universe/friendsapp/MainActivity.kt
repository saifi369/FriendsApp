package com.u4universe.friendsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.u4universe.friendsapp.signup.SignUpScreen
import com.u4universe.friendsapp.ui.theme.FriendsAppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      FriendsAppTheme {
        FriendsApp()
      }
    }
  }
}

@Composable
fun FriendsApp() {
  SignUpScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
  FriendsAppTheme {
    SignUpScreen()
  }
}