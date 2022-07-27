package com.sursulet.realestatemanager.di

import com.sursulet.realestatemanager.data.repository.EstateRepositoryImpl
import com.sursulet.realestatemanager.data.repository.GeocodingRepositoryImpl
import com.sursulet.realestatemanager.data.repository.PhotoRepositoryImpl
import com.sursulet.realestatemanager.domain.repository.EstateRepository
import com.sursulet.realestatemanager.domain.repository.GeocodingRepository
import com.sursulet.realestatemanager.domain.repository.PhotoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@ExperimentalCoroutinesApi
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

    @Binds
    @Singleton
    abstract fun bindPhotoRepository(
        estateRepositoryImpl: PhotoRepositoryImpl
    ): PhotoRepository
}