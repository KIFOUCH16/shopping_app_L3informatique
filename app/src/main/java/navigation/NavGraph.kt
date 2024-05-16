package com.example.myapplication8.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screens.ShoppingListScreen
import com.example.myapplication.ui.screens.SignupScreen
import com.example.myapplication.ui.screens.WelcomeScreen
import com.example.myapplication8.ui.screens.*

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("signup") { SignupScreen(navController) }
        composable("shoppingList") { ShoppingListScreen(navController) }
        composable("addItem") { AddItemScreen(navController) }
        composable("updateItem") { UpdateItemScreen(navController) }
    }
}