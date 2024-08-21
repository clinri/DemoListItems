package ru.borisov.list_items.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.borisov.domain.api.DeleteItemUseCase
import ru.borisov.domain.api.GetItemsUseCase
import ru.borisov.domain.api.UpdateItemUseCase
import ru.borisov.list_items.presentation.ListItemsContract.Effect
import ru.borisov.list_items.presentation.ListItemsContract.Event
import ru.borisov.list_items.presentation.ListItemsContract.State
import ru.borisov.models.Item
import javax.inject.Inject

@HiltViewModel
class ListItemsViewModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase,
    private val updateItemUseCase: UpdateItemUseCase,
    private val deleteItemUseCase: DeleteItemUseCase,
) : ViewModel(), CoroutineScope {

    override val coroutineContext = viewModelScope.coroutineContext

    private val _state: MutableStateFlow<State> = MutableStateFlow(State())
    val state = _state.asStateFlow()

    private val _event: MutableSharedFlow<Event> = MutableSharedFlow()
    private val event = _event.asSharedFlow()

    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    init {
        subscribeEvents()
        loadItems()
    }

    fun sendEvent(producer: () -> Event) {
        launch { _event.emit(producer()) }
    }

    private fun sendEffect(builder: () -> Effect) {
        launch { _effect.send(builder()) }
    }

    private fun setState(reduce: State.() -> State) {
        _state.update { it.reduce() }
    }

    private fun subscribeEvents() {
        event.onEach { handleEvent(it) }
            .launchIn(this)
    }

    private fun handleEvent(event: Event) {
        when (event) {
            is Event.OnClickDelete -> sendEffect { Effect.ToDeleteDialog(event.item) }
            is Event.OnClickEdit -> sendEffect { Effect.ToEditDialog(event.item) }
            is Event.OnChangeItem -> updateItem(event.item)
            is Event.OnDeleteItem -> deleteItem(event.item)
        }
    }

    private fun loadItems() = viewModelScope.launch {
        getItemsUseCase().collect {
            setState { copy(listItems = it) }
        }
    }

    private fun deleteItem(item: Item) {
        launch { deleteItemUseCase(item) }
    }

    private fun updateItem(item: Item) {
        launch { updateItemUseCase(item) }
    }
}