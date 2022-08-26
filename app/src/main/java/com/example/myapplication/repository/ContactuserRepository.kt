package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.data.ContactuserDao
import com.example.myapplication.data.ContactUser

class ContactuserRepository (private val contactuserDao: ContactuserDao){
val readallData :LiveData<List<ContactUser>> =contactuserDao.readAllData()

suspend fun addContactuser(contactuser: ContactUser){

    contactuserDao.addContactuser(contactuser)
}
suspend fun updateContactuser(contactuser: ContactUser){

    contactuserDao.updateContactuser(contactuser)
}

suspend fun deleteContactuser(contactuser: ContactUser){
    contactuserDao.deleteContactuser(contactuser)
}
suspend fun deleteAllContacts(){
    contactuserDao.deleteAllContacts()
}




}