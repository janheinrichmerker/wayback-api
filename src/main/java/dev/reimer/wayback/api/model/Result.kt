package dev.reimer.wayback.api.model

import dev.reimer.wayback.api.util.URLSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.net.URL

@Serializable
data class Result(
    @Serializable(with = URLSerializer::class) val url: URL,
    @SerialName("archived_snapshots") val archivedSnapshots: Snapshots
)
