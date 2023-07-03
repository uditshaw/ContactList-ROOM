package com.example.roomtutorial

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity is same as a table in room.
@Entity
data class Contact(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
