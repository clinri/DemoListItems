package ru.borisov.data.impl.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.borisov.data.api.ItemRepository
import ru.borisov.data.impl.db.dao.DaoItems
import ru.borisov.data.impl.db.toModel
import ru.borisov.data.impl.db.toEntity
import ru.borisov.models.Item
import javax.inject.Inject

class ItemRepositoryImpl @Inject constructor(
    private val itemDao: DaoItems,
) : ItemRepository {

    override fun getAllItems(): Flow<List<Item>> {
        return itemDao.getAll().map { listEntity ->
            listEntity.map { it.toModel() }
        }
    }

    override suspend fun updateItem(item: Item) {
        itemDao.update(item.toEntity())
    }

    override suspend fun deleteItem(item: Item) {
        itemDao.delete(item.toEntity())
    }
}