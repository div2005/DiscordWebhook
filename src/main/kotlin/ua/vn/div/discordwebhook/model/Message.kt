package ua.vn.div.discordwebhook.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Message(
    @SerialName("avatar_url")
    val avatarUrl: String,
    val username: String,
    val content: String,
    val embeds: List<Embed>,
    @SerialName("allowed_mentions")
    val allowedMentions: AllowedMentions
)
