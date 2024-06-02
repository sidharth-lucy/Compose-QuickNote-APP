package com.example.quicknote.repository.impl

import com.example.quicknote.dao.NoteDataDao
import com.example.quicknote.data.NoteData
import com.example.quicknote.repository.NoteBookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class NoteBookRepositoryImpl(private val noteDataDao: NoteDataDao): NoteBookRepository {
    override suspend fun getAllNotesData(): Flow<List<NoteData>>{
        return noteDataDao.getAllNoteData()

    }

    override suspend fun addNewNoteData(noteData: NoteData) {
        noteDataDao.addNewNoteItem(noteData)
    }

    override suspend fun deleteNoteData(noteData: NoteData) {
        noteDataDao.deleteNote(noteData)
    }
}