package com.example.quicknote.quickNaviation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quicknote.component.dummyNoteList
import com.example.quicknote.screen.AddNewNoteItemScreen
import com.example.quicknote.screen.NoteBookHomeScreen
import com.example.quicknote.viewmodel.NoteHomeScreenViewModel
import kotlinx.coroutines.flow.collect


@Composable
fun QuickNoteNavigationGraph(modifier: Modifier = Modifier) {
    val noteNavigationController = rememberNavController()

    Scaffold(modifier = modifier.fillMaxSize()) {
        val bottomPadding = it.calculateBottomPadding()
        val topPadding = it.calculateTopPadding()

        NavHost(
            modifier = Modifier.padding(bottom = bottomPadding, top = topPadding),
            navController = noteNavigationController,
            startDestination = QuickNoteRoutes.HomeScreenRoute.route
        ) {
            composable(route = QuickNoteRoutes.HomeScreenRoute.route) {
                val homeViewModel: NoteHomeScreenViewModel = hiltViewModel()
                val noteListData = homeViewModel.noteList.collectAsState().value
                NoteBookHomeScreen(modifier = Modifier, noteList = noteListData,
                    onNoteItemClicked = {
                        homeViewModel.deleteNoteData(it)
                    },
                    onAddNewNoteClicked = {
                        noteNavigationController.navigate(route= QuickNoteRoutes.AddNewNoteScreen.route)
                    }
                )
            }

            composable(route = QuickNoteRoutes.AddNewNoteScreen.route) {
                val homeViewModel: NoteHomeScreenViewModel = hiltViewModel()
                AddNewNoteItemScreen(modifier=Modifier, onAddNewNoteData = {
                    homeViewModel.addNoteItem(it)
                    noteNavigationController.navigate(route= QuickNoteRoutes.HomeScreenRoute.route)
                })
            }

            composable(route = QuickNoteRoutes.DetailScreen.route) {

            }
        }

    }


}


sealed class QuickNoteRoutes(val route: String) {
    data object HomeScreenRoute : QuickNoteRoutes("HomeScreen")
    data object DetailScreen : QuickNoteRoutes("DetailScreen")
    data object AddNewNoteScreen : QuickNoteRoutes("AddNewNoteScreen")
}
