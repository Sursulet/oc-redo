package com.sursulet.realestatemanager.data.network

import android.net.ConnectivityManager
import android.net.Network
import com.sursulet.realestatemanager.domain.network.NetworkManager
import javax.inject.Inject

class DefaultNetworkManager @Inject constructor(
    private val connectivityManager: ConnectivityManager
) : NetworkManager {
    override suspend fun getCurrentConnectivity() {
        val callback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                super.onAvailable(network)
                //trySend(true)
            }

            override fun onLost(network: Network) {
                super.onLost(network)
                //trySend(false)
            }
        }

        /*val manager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        manager.registerNetworkCallback(
            NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build(),
            callback
        )

         */
    }
}