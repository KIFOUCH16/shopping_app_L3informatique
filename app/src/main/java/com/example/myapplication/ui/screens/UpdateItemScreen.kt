package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppinglist.data.model.ShoppingItem
import com.example.shoppinglist.viewmodel.ShoppingViewModel

@Composable
fun UpdateItemScreen(
    item: ShoppingItem,
    onItemUpdated: () -> Unit,
    viewModel: ShoppingViewModel = viewModel()
) {
    var name by remember { mutableStateOf(item.name) }
    var quantity by remember { mutableStateOf(item.quantity.toString()) }
    var description by remember { mutableStateOf(item.description ?: "") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Item Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = quantity,
            onValueChange = { quantity = it },
            label = { Text("Quantity") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                viewModel.update(
                    ShoppingItem(
                        id = item.id,
                        name = name,
                        quantity = quantity.toInt(),
                        description = description.ifEmpty { null }
                    )
                )
                onItemUpdated()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Update Item")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UpdateItemScreenPreview() {
    UpdateItemScreen(
        item = ShoppingItem(id = 0, name = "Sample Item", quantity = 1, description = "Sample Description"),
        onItemUpdated = {}
    )
}
