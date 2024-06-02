package com.example.quicknote.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.example.quicknote.data.NoteData
import com.example.quicknote.quickNaviation.QuickNoteNavigationGraph
import com.example.quicknote.repository.NoteBookRepository
import com.example.quicknote.ui.theme.QuickNoteTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QuickNoteTheme {
                App()
            }
        }


    }


}

@Composable
fun App(modifier: Modifier = Modifier) {
    QuickNoteNavigationGraph(modifier= modifier)
}

