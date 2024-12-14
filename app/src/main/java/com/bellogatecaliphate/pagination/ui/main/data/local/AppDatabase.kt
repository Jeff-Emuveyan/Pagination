package com.bellogatecaliphate.pagination.ui.main.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bellogatecaliphate.pagination.ui.main.model.local.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    
    abstract fun userDao(): UserDao
}