package org.skunkworks.project.presentation.utils


fun Double.formatTemp(): String {
    val rounded = kotlin.math.round(this * 10) / 10
    val str = if (rounded == rounded.toLong().toDouble()) "${rounded.toLong()}.0" else rounded.toString()
    return "${str}°C"
}

fun Double.roundTo1Decimal(): String {
    val rounded = kotlin.math.round(this * 10) / 10
    return if (rounded == rounded.toLong().toDouble()) "${rounded.toLong()}.0" else rounded.toString()
}