package ua.vn.div.discordwebhook.model

import kotlinx.datetime.Instant
import kotlinx.datetime.serializers.InstantIso8601Serializer
import kotlinx.serialization.Serializable

@Serializable
data class Embed(
    val title: String,
    val color: Int? = null,
    val description: String? = null,
    val url: String? = null,

    @Serializable(with = InstantIso8601Serializer::class)
    val timestamp: Instant? = null,

    val author: Author? = null,
    val image: Image? = null,
    val thumbnail: Image? = null,
    val footer: Footer? = null,
    val fields: List<Field> = emptyList()
)
