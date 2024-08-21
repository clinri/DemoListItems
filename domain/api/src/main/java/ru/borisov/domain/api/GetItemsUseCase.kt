package ru.borisov.domain.api

import kotlinx.coroutines.flow.Flow
import ru.borisov.models.Item

interface GetItemsUseCase {

    operator fun invoke(): Flow<List<Item>>
}