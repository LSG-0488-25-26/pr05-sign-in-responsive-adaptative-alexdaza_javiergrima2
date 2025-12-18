package com.example.responsiveadaptative

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.responsiveadaptative.ui.theme.ResponsiveAdaptativeTheme
import com.example.responsiveadaptative.view.Routes
import com.example.responsiveadaptative.view.CrearCuenta
import com.example.responsiveadaptative.view.IniciarSesion



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResponsiveAdaptativeTheme {
                Main()
                }
            }
        }
    }


@Composable
fun Main() {

    val navigationController = rememberNavController()

    NavHost(
        navController = navigationController,
        startDestination = Routes.CrearCuenta.route
    ) {

        composable(Routes.CrearCuenta.route){
            CrearCuenta(navigationController)
        }

        composable(Routes.IniciarSesion.route){
            IniciarSesion(navigationController)
        }

    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ResponsiveAdaptativeTheme {
        Main()
    }
}