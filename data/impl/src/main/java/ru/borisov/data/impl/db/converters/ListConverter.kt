package ru.borisov.data.impl.db.converters

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class ListConverter {
    @TypeConverter
    fun fromList(list: List<String?>): String {
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun toList(data: String): List<String> {
        return Json.decodeFromString(data)
    }
}