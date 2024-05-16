package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screens.ShoppingListScreen
import com.example.shoppinglist.ui.screens.*
import com.example.myapplication.ui.screens.UpdateItemScreen
import com.example.myapplication.ui.screens.WelcomeScreen
import com.example.shoppinglist.ui.theme.ShoppingListTheme
import com.example.shoppinglist.viewmodel.ShoppingViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingListTheme {
                val navController = rememberNavController()
                val viewModel: ShoppingViewModel = viewModel()
                NavHost(navController, startDestination = "welcome") {
                    composable("welcome") {
                        WelcomeScreen(onNavigateToList = { navController.navigate("list") })
                    }
                    composable("list") {
                        ShoppingListScreen(
                            onNavigateToAddItem = { navController.navigate("add") },
                            onNavigateToUpdateItem = { item ->
                                // Pass the item data to the update screen
                                navController.navigate("update/${item.id}")
                            }
                        )
                    }
                    composable("add") {
                        AddItemScreen(onItemAdded = { navController.popBackStack() })
                    }
                    composable("update/{itemId}") { backStackEntry ->
                        val itemId = backStackEntry.arguments?.getString("itemId")?.toInt() ?: 0
                        val item = viewModel.allItems.value?.find { it.id == itemId }
                        item?.
                        let {
                            UpdateItemScreen(
                                item = it,
                                onItemUpdated = { navController.popBackStack() }
                            )
                        }
                    }
                }
            }
        }
    }
}
