package com.example.myapplication.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "contactUser_table")
data class ContactUser (
   @PrimaryKey(autoGenerate = true)
   val id:Int,
   val firstName: String ,
   val lastName:String,
   val number:String

): Parcelable
