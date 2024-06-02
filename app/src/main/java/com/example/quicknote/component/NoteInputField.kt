package com.example.quicknote.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun NoteInputField(
    modifier: Modifier = Modifier,
    label: String,
    inputVal: String,
    minLine:Int=1,
    maxLine:Int=1,
    keyboardActions: KeyboardActions,
    keyboardOptions: KeyboardOptions,
    onValueChange: (value: String) -> Unit
) {

    TextField(
        modifier = modifier
            .fillMaxWidth(),
        value = inputVal,
        enabled = true,
        readOnly = false,
        maxLines = maxLine,
        minLines = minLine,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFE9CFFA)
        ),
        onValueChange = {
            onValueChange(it)
        },
        label = {
            Text(text = label, style = MaterialTheme.typography.labelLarge)
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions
    )

}


@Preview(showBackground = true)
@Composable
private fun NoteInputFieldPrev() {
    NoteInputField(modifier = Modifier, label = "Note Heading", "", minLine = 1, maxLine = 1,
        KeyboardActions(onNext = {

        }), keyboardOptions = KeyboardOptions()
        , onValueChange = {}
    )
}

