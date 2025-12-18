package com.example.responsiveadaptative.model

data class Usuario(
    var nombre: String,
    var apellido: String,
    var apellido2: String,
    var fechaNacimiento: String,
    var email: String,
    var telefono: String,
    val nombreUsuario: String,
    val contraseña: String,
    val confirmarContrasena: String,
    var terminosAceptados: Boolean = false
)
