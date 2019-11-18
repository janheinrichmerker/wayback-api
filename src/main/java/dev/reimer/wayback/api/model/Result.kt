package dev.reimer.wayback.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Result(
    @SerialName("archived_snapshots") val archivedSnapshots: Snapshots
)
