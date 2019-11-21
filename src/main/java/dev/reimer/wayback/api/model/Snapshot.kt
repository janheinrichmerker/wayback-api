package dev.reimer.wayback.api.model

import dev.reimer.wayback.api.util.DateSerializer
import dev.reimer.wayback.api.util.URLSerializer
import kotlinx.serialization.Serializable
import java.net.URL
import java.time.LocalDateTime

@Serializable
data class Snapshot(
    val available: Boolean,
    @Serializable(with = URLSerializer::class)
    val url: URL,
    @Serializable(with = DateSerializer::class)
    val timestamp: LocalDateTime,
    val status: Int
)
