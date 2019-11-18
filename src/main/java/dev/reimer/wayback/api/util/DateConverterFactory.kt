package dev.reimer.wayback.api.util

import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type
import java.time.LocalDateTime

object DateConverterFactory : Converter.Factory() {

    override fun stringConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, String>? {
        if (type !is Class<*>) return null
        if (type != LocalDateTime::class.java) return null
        return StringConverter
    }

    object StringConverter : Converter<LocalDateTime, String> {
        override fun convert(value: LocalDateTime): String =
            WaybackDateTimeFormatter.format(value)
    }
}