package org.skunkworks.project

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.skunkworks.project.di.appModule
import org.skunkworks.project.presentation.navigation.MarsWeatherNavHost
import org.skunkworks.project.presentation.theme.MarsTheme

@Composable
@Preview
fun App() {
    KoinApplication(application = { modules(appModule) }) {
        MarsTheme {
            MarsWeatherNavHost()
        }
    }
}