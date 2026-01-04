package org.skunkworks.project.presentation.navigation

import androidx.compose.runtime.*
import org.skunkworks.project.domain.model.Sol
import org.skunkworks.project.presentation.screens.soldetail.SolDetailScreen
import org.skunkworks.project.presentation.screens.sollist.SolListScreen

sealed interface Screen {
    data object SolList : Screen
    data class SolDetail(val sol: Sol) : Screen
}

@Composable
fun MarsWeatherNavHost() {
    var currentScreen: Screen by remember { mutableStateOf(Screen.SolList) }

    when (val screen = currentScreen) {
        is Screen.SolList -> {
            SolListScreen(
                onSolClick = { sol -> currentScreen = Screen.SolDetail(sol) }
            )
        }
        is Screen.SolDetail -> {
            SolDetailScreen(
                sol = screen.sol,
                onBack = { currentScreen = Screen.SolList }
            )
        }
    }
}