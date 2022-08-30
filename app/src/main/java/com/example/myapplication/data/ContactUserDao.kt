package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactUserDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addContactuser(contactuser: Contactuser)

    @Update
    suspend fun updateContactuser(contactuser: Contactuser)

    @Delete
    suspend fun deleteContactuser(contactuser: Contactuser)

    @Query("DELETE FROM CONTACTUSER_TABLE")
    suspend fun deleteAllContacts()

    @Query("SELECT * FROM contactuser_table ORDER BY id ASC")
    fun  readAllData ():LiveData<List<Contactuser>>
}