package com.sursulet.realestatemanager.domain.network

interface NetworkManager {
    suspend fun getCurrentConnectivity()
}