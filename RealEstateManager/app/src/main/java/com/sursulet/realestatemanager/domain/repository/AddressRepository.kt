package com.sursulet.realestatemanager.domain.repository

import com.sursulet.realestatemanager.data.local.AddressDto
import kotlinx.coroutines.flow.Flow

interface AddressRepository {
    suspend fun insert(address: AddressDto)
    suspend fun update(address: AddressDto)
    suspend fun getAddressById(id: Long)
    fun getAddresses(): Flow<List<AddressDto>>
}