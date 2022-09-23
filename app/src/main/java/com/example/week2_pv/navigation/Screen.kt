package com.example.week2_pv.navigation

sealed class Screen(val route: String) {
    object SplashScreen: Screen("splash_screen")
    object HomeScreen: Screen("home_screen")
    object FormScreen: Screen("form_screen?title={title}&id={id}") {
        fun passTitlenId(title: String = "Tambah", id: String = ""): String {
            return "form_screen?title=$title&id=$id"
        }
    }
}