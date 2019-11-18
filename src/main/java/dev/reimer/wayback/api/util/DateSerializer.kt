package dev.reimer.wayback.api.util

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@Serializer(forClass = Date::class)
object DateSerializer : KSerializer<Date> {
    private val format: DateFormat = SimpleDateFormat("yyyyMMddHHmmss")

    override fun serialize(encoder: Encoder, obj: Date) {
        encoder.encodeString(format.format(obj))
    }

    override fun deserialize(decoder: Decoder): Date {
        return format.parse(decoder.decodeString())
    }
}