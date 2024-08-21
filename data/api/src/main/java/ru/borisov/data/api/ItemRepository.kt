package ru.borisov.data.api

import kotlinx.coroutines.flow.Flow
import ru.borisov.models.Item

interface ItemRepository {

    fun getAllItems(): Flow<List<Item>>
    suspend fun updateItem(item: Item)
    suspend fun deleteItem(item: Item)
}