package dev.reimer.wayback.api.util

import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAccessor

object WaybackDateTimeFormatter {
    private val formatter: DateTimeFormatter =
        DateTimeFormatter.ofPattern("yyyyMMddHHmmss")

    fun format(temporal: TemporalAccessor): String = formatter.format(temporal)

    fun parse(temporal: CharSequence): TemporalAccessor = formatter.parse(temporal)
}
