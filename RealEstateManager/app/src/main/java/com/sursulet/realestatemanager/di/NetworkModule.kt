package com.sursulet.realestatemanager.di

import com.sursulet.realestatemanager.data.network.DefaultNetworkManager
import com.sursulet.realestatemanager.domain.network.NetworkManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    @Binds
    @Singleton
    abstract fun bindNetworkManager(
        defaultNetworkManager: DefaultNetworkManager
    ): NetworkManager
}