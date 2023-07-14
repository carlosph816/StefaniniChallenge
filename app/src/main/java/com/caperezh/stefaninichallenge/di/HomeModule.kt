package com.caperezh.stefaninichallenge.di

import com.caperezh.stefaninichallenge.data.model.repository.HomeRepository
import com.caperezh.stefaninichallenge.data.model.repository.HomeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class HomeModule {

    @Binds
    abstract fun provideLoginRepositoryImp(
        implementation: HomeRepositoryImpl
    ): HomeRepository
}