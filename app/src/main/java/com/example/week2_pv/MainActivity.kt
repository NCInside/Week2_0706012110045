package com.example.week2_pv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.week2_pv.navigation.SetupNavGraph
import com.example.week2_pv.ui.theme.Week2_pvTheme
import com.google.accompanist.insets.ProvideWindowInsets

class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProvideWindowInsets {
                Week2_pvTheme {

                    navController = rememberNavController()
                    SetupNavGraph(navController = navController)

                }
            }
        }
    }

}