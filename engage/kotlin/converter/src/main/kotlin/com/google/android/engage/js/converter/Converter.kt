package com.google.android.engage.js.converter

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString

@Serializable
enum class WatchNextType {
    CONTINUE,
    @SerialName("NEXT")
    TYPE_NEXT,
    @SerialName("NEW")
    TYPE_NEW,
    @SerialName("UNSPECIFIED")
    TYPE_UNSPECIFIED
}

@Serializable
data class MovieEntity(
    val id: String,
    val watchNextType: WatchNextType,
)

fun main() {
    val movieEntity = MovieEntity(
        id = "my-movie-entity",
        watchNextType = WatchNextType.TYPE_NEW,
    )

    val json = Json.encodeToString(movieEntity)
    println(json)

    val json2 = """
        {
        "id": "my-movie-entity",
        "watchNextType":"CONTINUE"
        }
    """.trimIndent()
    println(Json.decodeFromString<MovieEntity>(json2))
}