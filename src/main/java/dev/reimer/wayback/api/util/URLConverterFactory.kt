package dev.reimer.wayback.api.util

import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type
import java.net.URL

object URLConverterFactory : Converter.Factory() {

    override fun stringConverter(
        type: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): Converter<*, String>? {
        if (type !is Class<*>) return null
        if (type != URL::class.java) return null
        return StringConverter
    }

    object StringConverter : Converter<URL, String> {
        override fun convert(value: URL): String = value.toExternalForm()
    }
}