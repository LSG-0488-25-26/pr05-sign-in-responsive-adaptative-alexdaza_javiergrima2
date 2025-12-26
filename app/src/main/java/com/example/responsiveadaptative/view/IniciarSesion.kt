package com.example.responsiveadaptative.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.responsiveadaptative.viewmodel.Formulario

@Composable
fun IniciarSesion(navigationController: NavHostController, formulario: Formulario = viewModel()) {

    var usuarioInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Iniciar Sesión")

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
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )

        if (loginError) {
            Text("Usuario o contraseña incorrecta")
        }

        Button(
            onClick = {
                loginError = !formulario.login(usuarioInput, passwordInput)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar Sesión")
        }

        Spacer(modifier = Modifier.height(16.dp))
        TextButton(onClick = { navigationController.navigate(Routes.CrearCuenta.route) }) {
            Text("¿No tienes cuenta? Regístrate")
        }
    }
}