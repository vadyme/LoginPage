package com.example.loginpage

import OutlinedTextFieldBackground
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(84.dp))
            Text(
                    text = stringResource(R.string.welcome_back),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
            )

        Spacer(modifier = Modifier.height(42.dp))

        var email by remember { mutableStateOf("") }
        OutlinedTextFieldBackground(colorResource(R.color.ri_field)) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = { newText ->
                    email = newText
                },
                label = {
                    Text(text = stringResource(R.string.email_address))
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true,
            )
        }

        var pass by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        OutlinedTextFieldBackground(colorResource(R.color.ri_field)) {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = pass,
                onValueChange = { newText ->
                    pass = newText
                },
                label = {
                    Text(text = stringResource(R.string.enter_password))
                },

                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.Absolute.Right,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                /*TODO: make clickable*/

                text = stringResource(R.string.forgot_password),
                color = colorResource(R.color.ri_additional_text)
            )
        }

        Spacer(modifier = Modifier.height(300.dp))

        GradientButton(
            onClick = { /*ToDo*/ },
            text = stringResource(R.string.log_in),
            textColor = Color.White,
            gradient = Brush.horizontalGradient(
                0.0f to colorResource(R.color.ri_grad_start),
                1.0f to colorResource(R.color.ri_grad_end)
            )
        )

        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = stringResource(R.string.do_not_have_account),
            color = colorResource(R.color.ri_hypertext)
        )

        Spacer(modifier = Modifier.height(3.dp))

        Text(
            text = stringResource(R.string.sign_up),
            color = colorResource(R.color.ri_hypertext)
        )

    }}
