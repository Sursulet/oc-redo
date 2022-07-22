package com.sursulet.realestatemanager.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [Estate::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RealEstateManagerDatabase : RoomDatabase() {

    abstract fun estateDao(): EstateDao
}