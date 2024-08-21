package ru.borisov.data.impl.db.converters

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {

    @TypeConverter
    fun toDate(dateLong: Long?): Date? {
        return dateLong?.let{ Date(dateLong)}
    }

    @TypeConverter
    fun fromDate(date: Date?): Long? {
        return date?.time
    }
}