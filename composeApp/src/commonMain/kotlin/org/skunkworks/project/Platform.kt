package org.skunkworks.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform