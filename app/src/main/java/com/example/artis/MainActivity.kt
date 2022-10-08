package com.example.artis


import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artis.ui.theme.ArtisTheme
import org.intellij.lang.annotations.JdkConstants
import androidx.compose.ui.text.input.ImeAction.Companion as ImeAction

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtisTheme {
                LoginUI()
            }
        }
    }
}

@Composable
fun LoginUI() {
    Scaffold(backgroundColor = Color(0xff003637)) {
        var username by remember {
            mutableStateOf("")
            }
        var password by remember {
            mutableStateOf("")
        }

        var isPasswordVisible by remember {
            mutableStateOf(false)
        }


        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.artis_1_removebg_preview), contentDescription = "Logo",
                modifier = Modifier
                    .weight(1f)
                    .size(1000.dp)
            )
            Card(
                Modifier
                    .weight(2f)
                    .padding(top = 10.dp, bottom = 0.dp, start = 10.dp, end = 10.dp),
                shape = RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp)
                ) {
                   Text(
                       text = "Welcome Back!",
                       fontWeight = FontWeight.Bold,
                       fontSize = 32.sp,
                   )
                   Column(
                       Modifier.fillMaxSize(),
                       horizontalAlignment = Alignment.CenterHorizontally,
                       verticalArrangement = Arrangement.Center
                   ){
                        OutlinedTextField(value = username,
                            onValueChange = {username = it},
                            Modifier.fillMaxWidth(),
                            label = {Text(text = "Username")},
                            leadingIcon = {
                                IconButton(onClick = { username = "" }) {
                                    Icon(
                                        Icons.Default.Person, contentDescription = "person"
                                    )
                                }
                            }
                        )
                       Spacer(modifier = Modifier.height(8.dp))
                       OutlinedTextField(
                           value = password,
                           onValueChange = {password = it},
                           Modifier.fillMaxWidth(),
                           keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = androidx.compose.ui.text.input.ImeAction.Done),
                           visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                           label = { Text(text = "Password")},
                           singleLine = true,
                           leadingIcon = {
                               Icon(
                                   Icons.Default.Lock, contentDescription = "lock"
                               )
                           },
                           trailingIcon = {
                               IconButton(onClick = {isPasswordVisible = !isPasswordVisible}) {
                                   Icon(
                                       Icons.Default.Info, contentDescription = "info"
                                   )
                               }
                           }
                       )
                       Spacer(modifier = Modifier.height(10.dp))
                       OutlinedButton(
                           onClick = {  },
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(bottom = 10.dp, top = 10.dp),
                                shape = RoundedCornerShape(16.dp)
                       ) {
                           Text(
                               text = "Login",
                               textAlign = TextAlign.Center,
                           )
                       }
                       Spacer(modifier = Modifier.weight(0.5f))
                       Row(
                           Modifier.fillMaxWidth(),
                           horizontalArrangement = Arrangement.SpaceBetween
                       ){
                           TextButton(onClick = {}) {
                               Text(text = "SignIn")
                           }
                           TextButton(onClick = {}) {
                               Text(text = "Forgot Password?", color = Color(0xff003637))
                           }
                       }
                   }

                }

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtisTheme {
        LoginUI()
    }
}