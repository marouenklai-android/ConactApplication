package com.example.myapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Contactuser::class],version =1,exportSchema = false )
abstract class ContactuserDatabase :RoomDatabase() {

    abstract fun contactuserDao():ContactUserDao
    companion object{
        @Volatile
        private var INSTANCE:ContactuserDatabase ? = null

        fun getDatabase(context:Context): ContactuserDatabase {
            val tempIstance = INSTANCE
            if (tempIstance != null) {

                return tempIstance
            }

            kotlin.synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactuserDatabase::class.java,
                    "contactuser_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }

}