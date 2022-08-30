package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.data.ContactUserDao
import com.example.myapplication.data.Contactuser

class ContactuserRepository (private val contactuserDao: ContactUserDao){
val readallData :LiveData<List<Contactuser>> =contactuserDao.readAllData()

suspend fun addContactuser(contactuser: Contactuser){

    contactuserDao.addContactuser(contactuser)
}
suspend fun updateContactuser(contactuser: Contactuser){

    contactuserDao.updateContactuser(contactuser)
}

suspend fun deleteContactuser(contactuser: Contactuser){
    contactuserDao.deleteContactuser(contactuser)
}
suspend fun deleteAllContacts(){
    contactuserDao.deleteAllContacts()
}

}