package ru.borisov.data.impl.db.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.borisov.data.api.ItemRepository
import ru.borisov.data.impl.repository.ItemRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
interface DataBindsModule {

    @Binds
    fun bindToolsRepository(impl: ItemRepositoryImpl): ItemRepository
}