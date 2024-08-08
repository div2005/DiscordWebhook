package ua.vn.div.discordwebhook.model

import kotlinx.serialization.Serializable

@Serializable
data class Field(
    val name: String,
    val value: String,
    val inline: Boolean = false,
)
