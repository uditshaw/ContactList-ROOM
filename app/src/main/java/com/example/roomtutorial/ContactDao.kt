package com.example.roomtutorial

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

//It provides Data access object of our database
//    Here goes all the functions we need to modify in our contacts table

@Dao
interface ContactDao {

    @Upsert
    suspend fun upsertContact(contact: Contact)
    //    Upsert is new annotation used in place of both Update & Insert.
    @Delete
    suspend fun deleteContact(contact: Contact)
//  Suspend will run in a coroutine and block the operations until the database operation finishes.


//We use Flow here as it is an Observable which notifies and updates as soon as there is a change in the Table. That is the power of ROOM.
//   The @Query parameter tells the functionality of the function.
    @Query("Select * from contact ORDER BY firstName ASC")
    fun getContactsOrderedByFirstName(): Flow<List<Contact>>

    @Query("Select * from contact ORDER BY lastName ASC")
    fun getContactsOrderedByLastName(): Flow<List<Contact>>

    @Query("Select * from contact ORDER BY phoneNumber ASC")
    fun getContactsOrderedByPhoneNumber(): Flow<List<Contact>>
}
