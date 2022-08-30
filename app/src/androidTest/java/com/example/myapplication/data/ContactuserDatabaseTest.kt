package com.example.myapplication.data

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.myapplication.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class ContactuserDatabaseTest{
    // A JUnit Test Rule that swaps the background executor
    // used by the Architecture Components with a different one
    // which executes each task synchronously
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var userDao: ContactUserDao
    private lateinit var db: ContactuserDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, ContactuserDatabase::class.java).build()
        userDao = db.contactuserDao()
    }
    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList()= runBlockingTest {
        val contactuser = Contactuser(1, "mar", "tar", "123")

        userDao.addContactuser(contactuser)
        val allContact = userDao.readAllData().getOrAwaitValue()
        assertThat(allContact).contains(contactuser)
    }


}