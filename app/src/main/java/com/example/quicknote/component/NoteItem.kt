package com.example.quicknote.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quicknote.data.NoteData


@Composable
fun NoteItem(modifier: Modifier = Modifier, data: NoteData, onLClickItem:(data: NoteData)->Unit) {
    Box(modifier = modifier
        .clip(shape = RoundedCornerShape(topStart = 30.dp, bottomEnd = 30.dp))
        .fillMaxWidth()
        .background(Color(0xFFCEFAD0))
        .clickable { onLClickItem(data) }) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp, horizontal = 18.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = data.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = data.description,
                style = MaterialTheme.typography.bodySmall,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
    Spacer(modifier = Modifier.height(6.dp))
}


@Composable
fun RoundedFloatingButton(modifier: Modifier = Modifier) {
    Box(modifier= modifier
        .size(65.dp)
        .clip(shape = CircleShape)
        .background(Color(0xFFE6FFE6))
        .border(width = 0.25.dp, color = Color(0XFF00ff00), shape = CircleShape),
        contentAlignment = Alignment.Center) {
        Icon(modifier = Modifier.size(35.dp), imageVector = Icons.Default.Add, contentDescription = "")
    }
}

@Composable
fun RoundedFloatingButton2(modifier: Modifier = Modifier, onAddNewNoteClicked:()->Unit) {
    FloatingActionButton(modifier = modifier
        .border(width = 0.25.dp, color = Color(0XFF00ff00), shape = CircleShape),
        containerColor = Color(0xFFE6FFE6),
        onClick = {
            onAddNewNoteClicked()
        },
        shape = CircleShape ) {

        Icon(modifier = Modifier.size(35.dp), imageVector = Icons.Default.Add, contentDescription = "")
    }
}




@Preview(showBackground = true)
@Composable
private fun RoundedFloatingButtonPrev2() {
    RoundedFloatingButton2(){}
}


@Preview(showBackground = true)
@Composable
private fun RoundedFloatingButtonPrev() {
    RoundedFloatingButton()
}




@Preview(showBackground = true)
@Composable
private fun NoteItemPrev() {
    NoteItem(modifier = Modifier , data = mockdata,{})
}

val mockdata = NoteData(title = "Do your Coding Work! Do your Coding Work Do your Coding Work",
    description ="Gemini in Android Studio is available in many countries and territories, with support for the English language." )