package ru.borisov.data.impl.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.borisov.data.impl.db.dao.DaoItems
import ru.borisov.data.impl.db.entity.ItemEntity

@Database(
    entities = [ItemEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDbRoom : RoomDatabase() {
    abstract fun daoItems(): DaoItems
}