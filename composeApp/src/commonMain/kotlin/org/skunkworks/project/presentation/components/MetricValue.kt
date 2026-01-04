package org.skunkworks.project.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.skunkworks.project.presentation.utils.roundTo1Decimal

@Composable
fun MetricValue(label: String, value: Double, unit: String) {
    Column {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = "${value.roundTo1Decimal()}$unit",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}