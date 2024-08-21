package ru.borisov.domain.impl.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.borisov.domain.api.DeleteItemUseCase
import ru.borisov.domain.api.GetItemsUseCase
import ru.borisov.domain.api.UpdateItemUseCase
import ru.borisov.domain.impl.usecases.DeleteItemUseCaseImpl
import ru.borisov.domain.impl.usecases.GetItemsUseCaseImpl
import ru.borisov.domain.impl.usecases.UpdateItemUseCaseImpl

@InstallIn(SingletonComponent::class)
@Module
interface DomainBindsModule {

    @Binds
    fun bindGetItemsUseCase(impl: GetItemsUseCaseImpl): GetItemsUseCase

    @Binds
    fun bindUpdateItemUseCase(impl: UpdateItemUseCaseImpl): UpdateItemUseCase

    @Binds
    fun bindDeleteItemUseCase(impl: DeleteItemUseCaseImpl): DeleteItemUseCase
}