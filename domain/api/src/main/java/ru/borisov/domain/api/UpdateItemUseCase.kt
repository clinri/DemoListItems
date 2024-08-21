package ru.borisov.domain.api

import ru.borisov.models.Item

interface UpdateItemUseCase {

   suspend operator fun invoke(item: Item)
}