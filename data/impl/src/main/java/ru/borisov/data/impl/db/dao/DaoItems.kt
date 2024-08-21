package ru.borisov.data.impl.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.borisov.data.impl.db.entity.ItemEntity

@Dao
interface DaoItems {

    @Query("SELECT * FROM item")
    fun getAll(): Flow<List<ItemEntity>>

    @Update
    suspend fun update(entity: ItemEntity)

    @Delete
    suspend fun delete(entity: ItemEntity)
}