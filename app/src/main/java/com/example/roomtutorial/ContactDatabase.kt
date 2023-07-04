//Database class
//In this abstract class, we define all our abstract vals

package com.example.roomtutorial

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Contact::class],
    version = 1
)
abstract class ContactDatabase : RoomDatabase() {
    abstract val dao : ContactDao
}