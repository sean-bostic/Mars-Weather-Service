package org.skunkworks.project.presentation.screens.sollist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.compose.koinInject
import org.skunkworks.project.domain.model.Sol
import org.skunkworks.project.presentation.components.ErrorContent
import org.skunkworks.project.presentation.components.SolListItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SolListScreen(
    onSolClick: (Sol) -> Unit,
    viewModel: SolListViewModel = koinInject()
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mars Weather") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when {
                state.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                state.error != null -> {
                    ErrorContent(
                        message = state.error!!,
                        onRetry = viewModel::loadSols,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                state.sols.isEmpty() -> {
                    Text(
                        text = "No weather data available",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
                else -> {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(state.sols, key = { it.solNumber }) { sol ->
                            SolListItem(sol = sol, onClick = { onSolClick(sol) })
                        }
                    }
                }
            }
        }
    }
}
