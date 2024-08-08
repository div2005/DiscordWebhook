package ua.vn.div.discordwebhook.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val name: String,
    @SerialName("url")
    val url: String,
    @SerialName("icon_url")
    val icon: String,
)
