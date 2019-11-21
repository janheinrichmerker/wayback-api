package dev.reimer.wayback.api.model

import dev.reimer.wayback.api.util.DateSerializer
import dev.reimer.wayback.api.util.URLSerializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.sink
import ru.gildor.coroutines.okhttp.await
import java.io.File
import java.net.URL
import java.time.LocalDateTime

@Serializable
data class Snapshot(
    val available: Boolean,
    @Serializable(with = URLSerializer::class)
    val url: URL,
    @Serializable(with = DateSerializer::class)
    val timestamp: LocalDateTime,
    val status: Int
) {

    companion object {
        val timestampRegex = Regex("[0-9]{14}")
    }

    fun getUrl(flag: UrlFlag): URL {
        if (flag == UrlFlag.DEFAULT) return url

        // Insert flag to URL path.
        val path = url.path
            .replaceFirst(timestampRegex, "$0${flag.flag}")
        val query = url.query?.let { "?$it" } ?: ""
        val file = path + query
        return URL(
            url.protocol,
            url.host,
            url.port,
            file
        )
    }

    suspend fun downloadTo(destination: File) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(getUrl(UrlFlag.IDENTITY))
            .build()
        val response = client.newCall(request).await()

        withContext(Dispatchers.IO) {
            // Clear output file.
            destination.mkdirs()
            if (destination.exists()) destination.delete()
            destination.createNewFile()

            // Copy response stream.
            response.body?.use { body ->
                body.source().use { source ->
                    destination.sink().use { sink ->
                        source.readAll(sink)
                    }
                }
            }
        }
    }
}
