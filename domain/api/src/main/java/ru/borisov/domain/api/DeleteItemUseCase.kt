package ru.borisov.domain.api

import ru.borisov.models.Item

interface DeleteItemUseCase {

    suspend operator fun invoke(item: Item)
}