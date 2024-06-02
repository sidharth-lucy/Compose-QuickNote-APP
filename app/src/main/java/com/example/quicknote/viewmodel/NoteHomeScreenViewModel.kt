package com.example.quicknote.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quicknote.data.NoteData
import com.example.quicknote.component.dummyNoteList
import com.example.quicknote.repository.NoteBookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteHomeScreenViewModel @Inject constructor(private val noteBookRepository: NoteBookRepository) :ViewModel(){

    private var _noteList = MutableStateFlow<List<NoteData>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        getAllNoteData()
    }

    fun addNoteItem(noteData: NoteData){
        viewModelScope.launch(Dispatchers.IO) {
            noteBookRepository.addNewNoteData(noteData)
        }

    }

    fun deleteNoteData(noteData: NoteData){
        viewModelScope.launch(Dispatchers.IO) {
            noteBookRepository.deleteNoteData(noteData)
        }
    }

    fun getAllNoteData(){
        viewModelScope.launch(Dispatchers.IO){
            noteBookRepository.getAllNotesData().distinctUntilChanged().collect {
                _noteList.value = it
            }
        }
    }

    ///// ####### version 1

    //    var _noteList = mutableStateListOf<NoteData>()
//    val noteList: SnapshotStateList<NoteData> = _noteList

    init {
//        _noteList.addAll(dummyNoteList)

    }

//    fun getAllNoteList():List<NoteData>{
//        val allNotes = noteBookRepository.getAllNotesData()
//    }

//    fun deleteNoteItem(noteData: NoteData){
//        _noteList.remove(noteData)
//    }

}