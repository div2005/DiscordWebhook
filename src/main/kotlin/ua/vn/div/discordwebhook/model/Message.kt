package ua.vn.div.discordwebhook.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Message(
    @SerialName("avatar_url")
    val avatarUrl: String? = null,
    val username: String? = null,
    val content: String? = null,
    val embeds: List<Embed>? = null,
    @SerialName("allowed_mentions")
    val allowedMentions: AllowedMentions? = null
)
