package com.example.myapplication.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactuserDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addContactuser(contactuser: ContactUser)

    @Update
    suspend fun updateContactuser(contactuser: ContactUser)

    @Delete
    suspend fun deleteContactuser(contactuser: ContactUser)

    @Query("DELETE FROM CONTACTUSER_TABLE")
    suspend fun deleteAllContacts()

    @Query("SELECT * FROM contactuser_table ORDER BY id ASC")
    fun  readAllData ():LiveData<List<ContactUser>>
}