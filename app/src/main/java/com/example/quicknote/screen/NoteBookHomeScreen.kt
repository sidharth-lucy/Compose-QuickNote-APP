package com.example.quicknote.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quicknote.data.NoteData
import com.example.quicknote.component.NoteListView
import com.example.quicknote.component.RoundedFloatingButton2
import com.example.quicknote.component.dummyNoteList


@Composable
fun NoteBookHomeScreen(
    modifier: Modifier = Modifier,
    noteList: List<NoteData>,
    onNoteItemClicked: (data: NoteData) -> Unit,
    onAddNewNoteClicked: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xfff6d5f7), Color(0xfffbe9d7)
                    )
                )
            )
    ) {
        NoteListView(modifier = Modifier,
            noteList = noteList,
            onNoteItemDelete = {
                onNoteItemClicked(it)
            })
        RoundedFloatingButton2(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = (-30).dp, y = (-45).dp)
                .size(70.dp),
            onAddNewNoteClicked = {
                onAddNewNoteClicked()
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
private fun NoteBookHomeScreenPre() {
    NoteBookHomeScreen(modifier = Modifier, noteList = dummyNoteList, {}, {})
}