package org.skunkworks.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.skunkworks.project.di.appModule
import org.skunkworks.project.presentation.navigation.MarsWeatherNavHost

@Composable
@Preview
fun App() {
    KoinApplication(application = { modules(appModule) }) {
        MaterialTheme {
            MarsWeatherNavHost()
        }
    }
}