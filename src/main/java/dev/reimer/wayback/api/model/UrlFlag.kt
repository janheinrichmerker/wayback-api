package dev.reimer.wayback.api.model

enum class UrlFlag(val flag: String) {
    DEFAULT(""),
    IDENTITY("id_"),
    JAVASCRIPT("js_"),
    CSS("cs_"),
    IMAGE("im_"),
    IFRAME("if_")
}