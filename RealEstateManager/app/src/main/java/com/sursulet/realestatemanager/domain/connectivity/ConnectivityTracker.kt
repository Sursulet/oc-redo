package com.sursulet.realestatemanager.domain.connectivity

import kotlinx.coroutines.flow.Flow

interface ConnectivityTracker {
    fun getCurrentConnectivity(): Flow<Status>

    enum class Status {
        Available, Unavailable, Losing, Lost
    }
}