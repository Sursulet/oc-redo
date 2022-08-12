package com.sursulet.realestatemanager.data.remote

import com.sursulet.realestatemanager.BuildConfig
import com.sursulet.realestatemanager.data.remote.dto.GeocodingDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodingApi {

    @GET("maps/api/geocode/json?")
    suspend fun getCoordinates(
        @Query("address") address: String,
        @Query("key") key: String = BuildConfig.API_KEY
    ): GeocodingDto
}