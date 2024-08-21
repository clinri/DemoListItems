package ru.borisov.data.impl.db

import ru.borisov.data.impl.db.entity.ItemEntity
import ru.borisov.models.Item

fun ItemEntity.toModel() = Item(
    id = id,
    name = name,
    time = time,
    tags = tags,
    amount = amount,
)

fun Item.toEntity() = ItemEntity(
    id = id,
    name = name,
    time = time,
    tags = tags,
    amount = amount,
)