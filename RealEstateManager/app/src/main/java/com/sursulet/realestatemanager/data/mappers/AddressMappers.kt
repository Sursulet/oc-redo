package com.sursulet.realestatemanager.data.mappers

import com.sursulet.realestatemanager.data.local.AddressDto
import com.sursulet.realestatemanager.domain.model.Address

fun AddressDto.toAddress(): Address {
    return Address(
        estateId = estateId,
        street = street,
        extras = extras,
        city = city,
        state = state,
        zip = zip,
        country = country
    )
}

fun Address.toAddressDto(): AddressDto {
    return AddressDto(
        estateId = estateId,
        street = street,
        extras = extras,
        city = city,
        state = state,
        zip = zip,
        country = country
    )
}