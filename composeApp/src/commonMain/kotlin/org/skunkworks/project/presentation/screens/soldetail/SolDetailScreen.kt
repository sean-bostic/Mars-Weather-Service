package org.skunkworks.project.presentation.screens.soldetail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.skunkworks.project.domain.model.Sol
import org.skunkworks.project.presentation.components.InfoCard
import org.skunkworks.project.presentation.components.MetricCard
import org.skunkworks.project.presentation.components.SeasonCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SolDetailScreen(
    sol: Sol,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sol ${sol.solNumber}") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("←")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SeasonCard(sol)
            sol.atmosphericTemp?.let { MetricCard("Temperature", it, "°C") }
            sol.pressure?.let { MetricCard("Pressure", it, " Pa") }
            sol.horizontalWindSpeed?.let { MetricCard("Wind Speed", it, " m/s") }
            sol.windDirection?.mostCommon?.let { wind ->
                InfoCard(
                    title = "Wind Direction",
                    content = "${wind.cardinal} (${wind.degrees.toInt()}°)"
                )
            }
        }
    }
}

