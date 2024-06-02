package com.example.quicknote.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quicknote.data.NoteData
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDataDao {

    @Query("SELECT * FROM note_data_table")
    fun getAllNoteData():Flow<List<NoteData>>

    @Delete
    fun deleteNote(noteData: NoteData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addNewNoteItem(noteData: NoteData)

}