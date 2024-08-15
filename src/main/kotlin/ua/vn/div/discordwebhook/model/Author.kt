package ua.vn.div.discordwebhook.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val name: String? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("icon_url")
    val icon: String? = null,
)
