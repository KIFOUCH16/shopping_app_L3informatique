package com.example.shoppinglist.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.shoppinglist.data.database.ShoppingDatabase
import com.example.shoppinglist.data.model.ShoppingItem
import com.example.shoppinglist.repository.ShoppingRepository
import kotlinx.coroutines.launch

class ShoppingViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ShoppingRepository
    val allItems: LiveData<List<ShoppingItem>>

    init {
        val shoppingItemDao = ShoppingDatabase.getDatabase(application).shoppingItemDao()
        repository = ShoppingRepository(shoppingItemDao)
        allItems = repository.allItems
    }

    fun insert(item: ShoppingItem) = viewModelScope.launch {
        repository.insert(item)
    }

    fun update(item: ShoppingItem) = viewModelScope.launch {
        repository.update(item)
    }

    fun delete(item: ShoppingItem) = viewModelScope.launch {
        repository.delete(item)
    }
}