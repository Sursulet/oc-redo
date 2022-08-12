package com.sursulet.realestatemanager.data.repository

import com.sursulet.realestatemanager.data.local.RealEstateManagerDatabase
import com.sursulet.realestatemanager.data.mappers.toAddress
import com.sursulet.realestatemanager.data.mappers.toAddressDto
import com.sursulet.realestatemanager.domain.model.Address
import com.sursulet.realestatemanager.domain.repository.AddressRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class AddressRepositoryImpl @Inject constructor(
    database: RealEstateManagerDatabase
) : AddressRepository {
    private val dao = database.addressDao()

    override suspend fun insert(address: Address) {
        dao.insert(address.toAddressDto())
    }

    override suspend fun update(address: Address) {
        TODO("Not yet implemented")
    }

    override suspend fun getAddressById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun getAddresses(): Flow<List<Address>> {
        return dao.getAddresses().map { addresses ->
            addresses.map { it.toAddress() }
        }
    }
}