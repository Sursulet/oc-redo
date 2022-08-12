package com.sursulet.realestatemanager.domain.repository

import com.sursulet.realestatemanager.domain.model.Address
import kotlinx.coroutines.flow.Flow

interface AddressRepository {
    suspend fun insert(address: Address)
    suspend fun update(address: Address)
    suspend fun getAddressById(id: Long)
    fun getAddresses(): Flow<List<Address>>
}