package com.example.responsiveadaptative.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.responsiveadaptative.viewmodel.Formulario

@Composable
fun IniciarSesion(navigationController: NavHostController, formulario: Formulario) {
    var usuarioInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf(false) }
    var logueado by remember { mutableStateOf(false) }

    if (logueado) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Bienvenido, $usuarioInput",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    logueado = false
                    usuarioInput = ""
                    passwordInput = ""
                }
            ) {
                Text("Cerrar sesión")
            }
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Banner()

            OutlinedTextField(
                value = usuarioInput,
                onValueChange = { usuarioInput = it },
                label = { Text("Nombre de Usuario") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = passwordInput,
                onValueChange = { passwordInput = it },
                label = { Text("Contraseña") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )

            if (loginError) {
                Text(
                    text = "Usuario o contraseña incorrectos",
                    color = MaterialTheme.colorScheme.error
                )
            }

            Button(
                onClick = {
                    if (formulario.login(usuarioInput, passwordInput)) {
                        loginError = false
                        logueado = true
                    } else {
                        loginError = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Iniciar Sesión")
            }

            Spacer(modifier = Modifier.height(16.dp))

            TextButton(
                onClick = { navigationController.navigate(Routes.CrearCuenta.route) }
            ) {
                Text("¿No tienes cuenta? Regístrate")
            }
        }
    }
}