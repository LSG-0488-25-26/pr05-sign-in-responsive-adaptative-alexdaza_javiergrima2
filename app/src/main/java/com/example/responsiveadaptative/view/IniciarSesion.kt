package com.example.responsiveadaptative.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.responsiveadaptative.R
import com.example.responsiveadaptative.viewmodel.Formulario

@Composable
fun IniciarSesion(navigationController: NavHostController, formulario: Formulario = viewModel()) {

    var usuarioInput by remember { mutableStateOf("") }
    var passwordInput by remember { mutableStateOf("") }
    var loginError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logogym),
                contentDescription = "Logo",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = "GymApp",
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = "Tu gimnasio de confianza",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {

            Text("Iniciar Sesión", style = MaterialTheme.typography.headlineMedium)

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
                Text(
                    text = "Usuario o contraseña incorrecta",
                    color = MaterialTheme.colorScheme.error
                )
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

            TextButton(
                onClick = {
                    navigationController.navigate(Routes.CrearCuenta.route)
                }
            ) {
                Text("¿No tienes cuenta? Regístrate")
            }
        }
    }
}