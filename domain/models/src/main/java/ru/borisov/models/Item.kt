package ru.borisov.models

import java.util.Date

data class Item(
    val id: Int = 0,
    val name: String = "Test text",
    val time: Date = Date(),
    val tags: List<String> = listOf("Apple", "Cherry"),
    val amount: Int = 222,
)
