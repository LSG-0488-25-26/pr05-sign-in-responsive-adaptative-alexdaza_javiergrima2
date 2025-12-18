package com.example.responsiveadaptative.viewmodel

import com.example.responsiveadaptative.model.Usuario

class Formulario {

    private val listaUsuarios = mutableListOf<Usuario>()

    fun login(
        nombre: String,
        apellido: String,
        apellido2: String,
        fechaNacimiento: String,
        email: String,
        telefono: String,
        nombreUsuario: String,
        contraseña: String,
        confirmarContrasena: String,
        terminosAceptados: Boolean = false
    ): Boolean {

        if (
            nombre.isBlank() ||
            apellido.isBlank() ||
            fechaNacimiento.isBlank() ||
            email.isBlank() ||
            telefono.isBlank() ||
            nombreUsuario.isBlank() ||
            contraseña.isBlank() ||
            confirmarContrasena.isBlank() ||
            !terminosAceptados
        ) {
            println("Todos los campos son obligatorios")
            return false
        }

        if (!terminosAceptados) {
            println("Debes aceptar los términos")
            return false
        }

        if (contraseña != confirmarContrasena) {
            println("Las contraseñas no coinciden")
            return false
        }

        val usuario = Usuario(
            nombre,
            apellido,
            apellido2,
            fechaNacimiento,
            email,
            telefono,
            nombreUsuario,
            contraseña,
            confirmarContrasena,
            terminosAceptados
        )

        listaUsuarios.add(usuario)

        println("Usuario registrado correctamente.")
        return true
    }
}