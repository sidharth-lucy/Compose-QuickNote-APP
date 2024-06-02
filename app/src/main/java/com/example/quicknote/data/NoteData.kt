package com.example.quicknote.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID


@Entity(tableName = "note_data_table")
data class NoteData(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val title: String,
    val description: String)


