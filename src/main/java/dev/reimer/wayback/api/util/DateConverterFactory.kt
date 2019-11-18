package dev.reimer.wayback.api.util

import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateConverterFactory : Converter.Factory() {

    override fun stringConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, String>? {
        if (type !is Class<*>) return null
        if (type != Date::class.java) return null
        return StringConverter
    }

    object StringConverter : Converter<Date, String> {
        private val format: DateFormat = SimpleDateFormat("yyyyMMddHHmmss")

        override fun convert(value: Date): String = format.format(value)
    }
}