package com.example.shoppinglist.repository

import androidx.lifecycle.LiveData
import com.example.shoppinglist.data.database.ShoppingItemDao
import com.example.shoppinglist.data.model.ShoppingItem

class ShoppingRepository(private val shoppingItemDao: ShoppingItemDao) {
    val allItems: LiveData<List<ShoppingItem>> = shoppingItemDao.getAllItems()

    suspend fun insert(item: ShoppingItem) {
        shoppingItemDao.insert(item)
    }

    suspend fun update(item: ShoppingItem) {
        shoppingItemDao.update(item)
    }

    suspend fun delete(item: ShoppingItem) {
        shoppingItemDao.delete(item)
    }
}