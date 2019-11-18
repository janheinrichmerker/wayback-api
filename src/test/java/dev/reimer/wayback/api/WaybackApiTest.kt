package dev.reimer.wayback.api

import dev.reimer.wayback.api.util.testBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.net.URL
import java.util.*

class WaybackApiTest {

    companion object {
        private const val URL_STRING = "http://example.com"
        private val URL = URL(URL_STRING)
        private val TIMESTAMP: Calendar = Calendar.getInstance().apply {
            set(2006, 1, 1)
        }
        private const val URL_EMPTY_STRING = "http://this.url.would.probably.never.be.indexed.by.the.web.archive"
        private val URL_EMPTY = URL(URL_EMPTY_STRING)
    }

    private lateinit var api: WaybackApi

    @BeforeEach
    fun configureSystemUnderTest() {
        api = WaybackApi()
    }

    @Test
    @DisplayName("Should find $URL_STRING snapshot.")
    fun shouldFindSnapshot() = testBlocking {
        val result = api.available(URL)
        assertThat(result.archivedSnapshots.closest).isNotNull()
    }

    @Test
    @DisplayName("Should not find $URL_EMPTY_STRING snapshot.")
    fun shouldNotFindSnapshot() = testBlocking {
        val result = api.available(URL_EMPTY)
        assertThat(result.archivedSnapshots.closest).isNull()
    }

    @Test
    @DisplayName("Should find $URL_STRING snapshot with timestamp.")
    fun shouldFindSnapshotForTimestamp() = testBlocking {
        val result = api.available(URL, TIMESTAMP)
        assertThat(result.archivedSnapshots.closest).isNotNull
    }

    @Test
    @DisplayName("Should match $URL_STRING url in result.")
    fun shouldMatchURL() = testBlocking {
        val result = api.available(URL)
        assertThat(result.url).isEqualTo(URL)
    }
}