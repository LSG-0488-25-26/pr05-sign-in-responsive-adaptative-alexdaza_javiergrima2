package com.example.responsiveadaptative.model

data class Usuario(
    var nombre_completo: String,
    var data_nacimiento: String,
    var email: String,
    var telefono: Int,
    val nombre_usuario: String,
    val contraseña: String,
    val confirmar_contraseña: String,
    var terminos_aceptados: Boolean = false,
)
