// ShoppingListScreen.kt

package com.example.myapplication.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppinglist.data.model.ShoppingItem
import com.example.shoppinglist.viewmodel.ShoppingViewModel
import kotlinx.coroutines.flow.collectAsState

@Composable
fun ShoppingListScreen(
    onNavigateToAddItem: () -> Unit,
    onNavigateToUpdateItem: (ShoppingItem) -> Unit,
    viewModel: ShoppingViewModel = viewModel()
) {
    val itemsState by viewModel.allItems.collectAsState(initial = listOf())
    val items = itemsState.value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Shopping List") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onNavigateToAddItem) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Item")
            }
        }

    )  {
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(items) { item ->
                ShoppingItemCard(item = item, onClick = { onNavigateToUpdateItem(item) })
            }
        }
    }
}

@Composable
fun ShoppingItemCard(item: ShoppingItem, onClick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = item.name, style = MaterialTheme.typography.h6)
            Text(text = "Quantity: ${item.quantity}", style = MaterialTheme.typography.body2)
            item.description?.let {
                Text(text = it, style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingListScreenPreview() {
    ShoppingListScreen(onNavigateToAddItem = {}, onNavigateToUpdateItem = {})
}
