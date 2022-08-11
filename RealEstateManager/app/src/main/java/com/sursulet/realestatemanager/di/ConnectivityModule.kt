package com.sursulet.realestatemanager.di

import com.sursulet.realestatemanager.data.connectivity.DefaultConnectivityTracker
import com.sursulet.realestatemanager.domain.connectivity.ConnectivityTracker
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ConnectivityModule {

    @Binds
    @Singleton
    abstract fun bindConnectivityTracker(
        defaultNetworkManager: DefaultConnectivityTracker
    ): ConnectivityTracker
}