package com.example.quicknote.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.quicknote.dao.NoteDataDao
import com.example.quicknote.data.NoteData


@Database(entities = [NoteData::class], version = 1)
abstract class NoteDataBase:RoomDatabase() {
    abstract fun getNoteDataDao(): NoteDataDao
}