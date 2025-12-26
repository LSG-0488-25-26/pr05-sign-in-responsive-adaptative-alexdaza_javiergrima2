package com.example.responsiveadaptative.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.responsiveadaptative.model.Usuario

class Formulario : ViewModel() {

    var nombre = mutableStateOf("")
    var apellido = mutableStateOf("")
    var apellido2 = mutableStateOf("")
    var fechaNacimiento = mutableStateOf("")
    var email = mutableStateOf("")
    var telefono = mutableStateOf("")
    var nombreUsuario = mutableStateOf("")
    var contraseña = mutableStateOf("")
    var confirmarContrasena = mutableStateOf("")
    var terminosAceptados = mutableStateOf(false)

    private val listaUsuarios = mutableListOf<Usuario>()

    fun validarFormulario(): Boolean {
        return nombre.value.isNotBlank() &&
                apellido.value.isNotBlank() &&
                fechaNacimiento.value.isNotBlank() &&
                email.value.contains("@") &&
                telefono.value.all { it.isDigit() } &&
                contraseña.value == confirmarContrasena.value &&
                terminosAceptados.value
    }

    fun registrarUsuario(): Boolean {
        if (!validarFormulario()) return false

        listaUsuarios.add(
            Usuario(
                nombre = nombre.value,
                apellido = apellido.value,
                apellido2 = apellido2.value,
                fechaNacimiento = fechaNacimiento.value,
                email = email.value,
                telefono = telefono.value,
                nombreUsuario = nombreUsuario.value,
                contraseña = contraseña.value,
                confirmarContrasena = confirmarContrasena.value,
                terminosAceptados = terminosAceptados.value
            )
        )
        return true
    }

    fun login(usuario: String, pass: String): Boolean {
        return listaUsuarios.any {
            it.nombreUsuario == usuario && it.contraseña == pass
        }
    }
}
