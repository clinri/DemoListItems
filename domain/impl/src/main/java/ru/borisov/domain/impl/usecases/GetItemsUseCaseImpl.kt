package ru.borisov.domain.impl.usecases

import kotlinx.coroutines.flow.Flow
import ru.borisov.models.Item
import ru.borisov.data.api.ItemRepository
import ru.borisov.domain.api.GetItemsUseCase
import javax.inject.Inject

class GetItemsUseCaseImpl @Inject constructor(
    private val itemRepository: ItemRepository,
) : GetItemsUseCase {

    override fun invoke(): Flow<List<Item>> {
       return itemRepository.getAllItems()
    }
}