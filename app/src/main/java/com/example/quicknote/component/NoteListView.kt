package com.example.quicknote.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quicknote.data.NoteData


@Composable
fun NoteListView(modifier: Modifier = Modifier, noteList:List<NoteData>, onNoteItemDelete:(data: NoteData)->Unit) {
    Box(modifier= modifier
        .fillMaxSize()
        .padding(top = 16.dp, bottom = 20.dp, start = 16.dp, end = 16.dp),
        contentAlignment = Alignment.TopCenter
        ) {
        LazyColumn(modifier=Modifier.fillMaxWidth()) {
            items(noteList, key = {it.id}){noteItem->
                Spacer(modifier = Modifier.height(8.dp))
                SwipeToDeleteContainer(item = noteItem, onDelete = {
                    onNoteItemDelete(it)
                }){
                    NoteItem(modifier=Modifier , data = it){

                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NoteListViewPrev() {
    NoteListView(modifier = Modifier, dummyNoteList,{})
}

val dummyNoteList = listOf(
    NoteData(title = "Note 1", description = "Description for Note 1"),
    NoteData(title = "Note 2", description = "Description for Note 2"),
    NoteData(title = "Note 3", description = "Description for Note 3"),
    NoteData(title = "Note 4", description = "Description for Note 4"),
    NoteData(title = "Note 5", description = "Description for Note 5"),
    NoteData(title = "Note 1", description = "Description for Note 1"),
    NoteData(title = "Note 2", description = "Description for Note 2"),
    NoteData(title = "Note 3", description = "Description for Note 3"),
    NoteData(title = "Note 4", description = "Description for Note 4"),
    NoteData(title = "Note 5", description = "Description for Note 5")
)