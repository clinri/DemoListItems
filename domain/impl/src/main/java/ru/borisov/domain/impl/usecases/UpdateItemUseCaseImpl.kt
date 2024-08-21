package ru.borisov.domain.impl.usecases

import ru.borisov.data.api.ItemRepository
import ru.borisov.domain.api.UpdateItemUseCase
import ru.borisov.models.Item
import javax.inject.Inject

class UpdateItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository,
) : UpdateItemUseCase {

    override suspend fun invoke(item: Item) {
        return itemRepository.updateItem(item)
    }
}