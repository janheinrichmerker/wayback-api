package dev.reimer.wayback.api

import dev.reimer.wayback.api.model.Result
import retrofit2.http.GET
import retrofit2.http.Query

import java.net.URL
import java.util.*

interface WaybackService {
    @GET("available")
    suspend fun available(
        @Query(value = "url", encoded = true) url: URL,
        @Query(value = "timestamp", encoded = true) timestamp: Date?
    ): Result
}
