package com.example.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.ContactuserDatabase
import com.example.myapplication.data.ContactUser
import com.example.myapplication.repository.ContactuserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContactuserViewModel(application: Application):AndroidViewModel (application){
    val readAllData : LiveData<List<ContactUser>>

    private val repository: ContactuserRepository

    init {
    val  contactuserDao= ContactuserDatabase.getDatabase(application).contactuserDao()
    repository =  ContactuserRepository(contactuserDao)
    readAllData= repository.readallData

    }


    fun addContactuser(contactuser: ContactUser){

    viewModelScope.launch(Dispatchers.IO) {
        repository.addContactuser(contactuser)
    }

    }


    fun updateContactuser(contactuser: ContactUser){

    viewModelScope.launch(Dispatchers.IO) {
        repository.updateContactuser(contactuser)
    }

    }
    fun deleteContactuser(contactuser: ContactUser){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteContactuser(contactuser)
        }
    }
    fun deleteAllContacts(){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAllContacts()
        }
    }


}
