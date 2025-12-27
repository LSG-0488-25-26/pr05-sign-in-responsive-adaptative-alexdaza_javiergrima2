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
fun CrearCuenta(navigationController: NavHostController, formulario: Formulario = viewModel()) {

    var registrado by remember { mutableStateOf(false) }

    if (registrado) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Usuario registrado correctamente")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navigationController.navigate(Routes.IniciarSesion.route) }) {
                Text("Ir a Login")
            }
        }
    } else {

        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

            val isCompact = maxWidth < 600.dp
            val isMedium = maxWidth in 600.dp..840.dp
            val isExpanded = maxWidth > 840.dp

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
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    OutlinedTextField(
                        value = formulario.nombre.value,
                        onValueChange = { formulario.nombre.value = it },
                        label = { Text("Nombre") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = formulario.apellido.value,
                        onValueChange = { formulario.apellido.value = it },
                        label = { Text("Apellido") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    if (!isCompact) {
                        OutlinedTextField(
                            value = formulario.apellido2.value,
                            onValueChange = { formulario.apellido2.value = it },
                            label = { Text("Segundo Apellido") },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    OutlinedTextField(
                        value = formulario.fechaNacimiento.value,
                        onValueChange = { formulario.fechaNacimiento.value = it },
                        label = { Text("Fecha de Nacimiento") },
                        placeholder = { Text("DD/MM/AAAA") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = formulario.email.value,
                        onValueChange = { formulario.email.value = it },
                        label = { Text("Email") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = formulario.telefono.value,
                        onValueChange = { formulario.telefono.value = it },
                        label = { Text("Teléfono") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = formulario.nombreUsuario.value,
                        onValueChange = { formulario.nombreUsuario.value = it },
                        label = { Text("Nombre de Usuario") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = formulario.contraseña.value,
                        onValueChange = { formulario.contraseña.value = it },
                        label = { Text("Contraseña") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )

                    OutlinedTextField(
                        value = formulario.confirmarContrasena.value,
                        onValueChange = { formulario.confirmarContrasena.value = it },
                        label = { Text("Confirmar Contraseña") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = formulario.terminosAceptados.value,
                            onCheckedChange = { formulario.terminosAceptados.value = it }
                        )
                        Text("Acepto los términos y condiciones")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            if (formulario.registrarUsuario()) {
                                registrado = true
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text("Registrar")
                    }
                }
            }
        }
    }
}
