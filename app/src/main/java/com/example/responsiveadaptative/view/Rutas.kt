package com.example.responsiveadaptative.view

sealed class Routes(val route: String)
{
    object CrearCuenta:Routes("CrearCuenta" )
    object IniciarSesion:Routes("IniciarSesion" )
}