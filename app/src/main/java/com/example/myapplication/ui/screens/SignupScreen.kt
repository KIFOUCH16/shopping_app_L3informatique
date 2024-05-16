
package com.example.myapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication8.R

@Composable
fun SignupScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var confirmPasswordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Sign Up",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(32.dp))
        TextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_person),
                    contentDescription = "User Icon"
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Enter Your Email") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_email),
                    contentDescription = "Email Icon"
                )
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Enter Your Phone") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_phone),
                    contentDescription = "Phone Icon"
                )
            },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Enter Your Password") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_lock),
                    contentDescription = "Lock Icon"
                )
            },
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else
                    Icons.Filled.VisibilityOff
IconButton(onClick = { passwordVisible = !passwordVisible }) {
    Icon(imageVector = image, contentDescription = "Toggle Password Visibility")
}
},
visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
modifier = Modifier.fillMaxWidth()
)
Spacer(modifier = Modifier.height(16.dp))
TextField(
value = confirmPassword,
onValueChange = { confirmPassword = it },
label = { Text("Re enter your password") },
leadingIcon = {
    Icon(
        painter = painterResource(id = R.drawable.ic_lock),
        contentDescription = "Lock Icon"
    )
},
trailingIcon = {
    val image = if (confirmPasswordVisible)
        Icons.Filled.Visibility
    else
        Icons.Filled.VisibilityOff

    IconButton(onClick = { confirmPasswordVisible = !confirmPasswordVisible }) {
        Icon(imageVector = image, contentDescription = "Toggle Password Visibility")
    }
},
visualTransformation = if (confirmPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
modifier = Modifier.fillMaxWidth()
)
Spacer(modifier = Modifier.height(32.dp))
Button(
onClick = { /* Handle Sign Up */ },
modifier = Modifier
.fillMaxWidth()
.height(50.dp)
) {
    Text(text = "Sign Up")
}
Spacer(modifier = Modifier.height(16.dp))
Row(
modifier = Modifier.align(Alignment.CenterHorizontally)
) {
    Text(text = "Already have an account?")
    Spacer(modifier = Modifier.width(4.dp))
    Text(
        text = "SignIn",
        style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary),
        modifier = Modifier.clickable {
            navController.navigate("login")
        }
    )
}
}
}