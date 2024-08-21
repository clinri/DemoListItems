package ru.borisov.data.impl.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import ru.borisov.data.impl.db.converters.DateConverter
import ru.borisov.data.impl.db.converters.ListConverter
import java.util.Date

@Entity(tableName = "item")
@TypeConverters(DateConverter::class, ListConverter::class)
data class ItemEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "time")
    val time: Date,
    @ColumnInfo(name = "tags")
    val tags: List<String>,
    @ColumnInfo(name = "amount")
    val amount: Int,
)