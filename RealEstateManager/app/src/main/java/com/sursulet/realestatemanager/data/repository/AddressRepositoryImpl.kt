package com.sursulet.realestatemanager.data.repository

import com.sursulet.realestatemanager.data.local.AddressDto
import com.sursulet.realestatemanager.data.local.RealEstateManagerDatabase
import com.sursulet.realestatemanager.domain.repository.AddressRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AddressRepositoryImpl @Inject constructor(
    database: RealEstateManagerDatabase
) : AddressRepository {
    private val dao = database.addressDao()

    override suspend fun insert(address: AddressDto) {
        TODO("Not yet implemented")
    }

    override suspend fun update(address: AddressDto) {
        TODO("Not yet implemented")
    }

    override suspend fun getAddressById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getAddresses(): Flow<List<AddressDto>> {
        return dao.getAddresses()
    }
}