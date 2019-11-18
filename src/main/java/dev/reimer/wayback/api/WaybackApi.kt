package dev.reimer.wayback.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dev.reimer.wayback.api.model.Result
import dev.reimer.wayback.api.util.DateConverterFactory
import dev.reimer.wayback.api.util.URLConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import java.net.URL
import java.util.*

open class WaybackApi : WaybackService {

    open val retrofitBuilder = Retrofit.Builder()
    open val baseUrl = "http://archive.org/wayback/"

    private val contentType: MediaType = MediaType.get("application/json")
    private val retrofit: Retrofit by lazy {
        retrofitBuilder
            .baseUrl(baseUrl)
            .addConverterFactory(URLConverterFactory)
            .addConverterFactory(DateConverterFactory)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .build()
    }

    val service: WaybackService by lazy {
        retrofit.create(WaybackService::class.java)
    }

    override suspend fun available(url: URL, timestamp: Date?): Result =
        service.available(url, timestamp)
}