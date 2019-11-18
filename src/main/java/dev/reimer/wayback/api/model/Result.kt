package dev.reimer.wayback.api.model

import dev.reimer.wayback.api.util.DateSerializer
import dev.reimer.wayback.api.util.URLSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.net.URL
import java.util.*

@Serializable
data class Result(
    @SerialName("archived_snapshots") val archivedSnapshots: Snapshots,
    @Serializable(with = URLSerializer::class) val url: URL,
    @Serializable(with = DateSerializer::class) val timestamp: Date? = null
)
