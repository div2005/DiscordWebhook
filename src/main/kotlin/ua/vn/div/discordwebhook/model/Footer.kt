package ua.vn.div.discordwebhook.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Footer(
    @SerialName("icon_url")
    val iconUrl: String,
    val text: String,
)
