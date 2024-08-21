package ru.borisov.domain.impl.usecases

import ru.borisov.data.api.ItemRepository
import javax.inject.Inject

class DeleteItemUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository,
) : ru.borisov.domain.api.DeleteItemUseCase {

    override suspend fun invoke(item: ru.borisov.models.Item) {
        return itemRepository.deleteItem(item)
    }
}