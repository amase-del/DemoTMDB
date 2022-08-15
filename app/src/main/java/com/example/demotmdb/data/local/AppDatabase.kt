package com.example.demotmdb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.demotmdb.data.GenreConverters
import com.example.demotmdb.model.Movie

@Database(entities = [Movie::class], version = 1)
@TypeConverters(GenreConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}