package org.skunkworks.project.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.skunkworks.project.domain.model.Sol

@Composable
fun SeasonCard(sol: Sol) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = sol.season.uppercase(),
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Northern: ${sol.northernSeason.uppercase()}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Southern: ${sol.southernSeason.uppercase()}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}