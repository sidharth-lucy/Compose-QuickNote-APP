package com.example.quicknote.repository

import com.example.quicknote.data.NoteData
import kotlinx.coroutines.flow.Flow

interface NoteBookRepository {

    suspend fun getAllNotesData():Flow<List<NoteData>>

    suspend fun addNewNoteData(noteData: NoteData)

    suspend fun deleteNoteData(noteData: NoteData)
}