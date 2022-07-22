package com.sursulet.realestatemanager.di

import com.sursulet.realestatemanager.data.repository.EstateRepositoryImpl
import com.sursulet.realestatemanager.data.repository.GeocodingRepositoryImpl
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import com.sursulet.realestatemanager.domain.repository.GeocodingRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindGeocodingRepository(
        geocodingRepositoryImpl: GeocodingRepositoryImpl
    ): GeocodingRepository

    @Binds
    @Singleton
    abstract fun bindEstateRepository(
        estateRepositoryImpl: EstateRepositoryImpl
    ): EstateRepository
}