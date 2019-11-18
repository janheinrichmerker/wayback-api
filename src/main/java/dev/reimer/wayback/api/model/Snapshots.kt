package dev.reimer.wayback.api.model

import kotlinx.serialization.Serializable

@Serializable
data class Snapshots(
    val closest: Snapshot?
)
