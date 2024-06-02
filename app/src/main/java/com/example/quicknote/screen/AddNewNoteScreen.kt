package com.example.quicknote.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.example.quicknote.data.NoteData
import com.example.quicknote.component.NoteInputField


@Composable
fun AddNewNoteItemScreen(modifier: Modifier = Modifier , onAddNewNoteData:(noteDta: NoteData)->Unit) {
    val inputStrTitle = remember {
        mutableStateOf("")
    }
    val inputStrDesc = remember {
        mutableStateOf("")
    }
    val localManager = LocalFocusManager.current

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 20.dp)
        ) {
            Text(
                text = "What do you want to note!!",
                style = MaterialTheme.typography.titleMedium,
                color = Color(
                    0xFFB35CEC
                ),
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            NoteInputField(
                modifier = Modifier,
                label = "Note Title",
                inputVal = inputStrTitle.value,
                keyboardActions = KeyboardActions(),
                keyboardOptions = KeyboardOptions(autoCorrect = true , imeAction = ImeAction.Next),
                onValueChange = {
                    inputStrTitle.value = it
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
            NoteInputField(
                modifier = Modifier,
                label = "Note Description",
                inputVal = inputStrDesc.value,
                minLine = 10,
                maxLine = 50,
                keyboardActions = KeyboardActions(onDone = {
                    onAddNewNoteData(NoteData(title = inputStrTitle.value , description = inputStrDesc.value))
                    localManager.clearFocus()
                }),
                keyboardOptions = KeyboardOptions(autoCorrect = true , imeAction = ImeAction.Done),
                onValueChange = {
                    inputStrDesc.value = it
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AddNewNoteScreenPrev() {
    AddNewNoteItemScreen(modifier = Modifier,{})
}