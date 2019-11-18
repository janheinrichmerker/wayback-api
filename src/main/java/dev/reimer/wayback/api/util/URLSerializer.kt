package dev.reimer.wayback.api.util

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import java.net.URL
import java.util.*

@Serializer(forClass = Date::class)
object URLSerializer : KSerializer<URL> {
    override fun serialize(encoder: Encoder, obj: URL) {
        encoder.encodeString(obj.toExternalForm())
    }

    override fun deserialize(decoder: Decoder): URL {
        return URL(decoder.decodeString())
    }
}