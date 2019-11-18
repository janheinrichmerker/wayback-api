package dev.reimer.wayback.api.util

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import java.time.LocalDateTime

@Serializer(forClass = LocalDateTime::class)
object DateSerializer : KSerializer<LocalDateTime> {
    override fun serialize(encoder: Encoder, obj: LocalDateTime) {
        encoder.encodeString(WaybackDateTimeFormatter.format(obj))
    }

    override fun deserialize(decoder: Decoder): LocalDateTime {
        return LocalDateTime.from(
            WaybackDateTimeFormatter.parse(decoder.decodeString())
        )
    }
}