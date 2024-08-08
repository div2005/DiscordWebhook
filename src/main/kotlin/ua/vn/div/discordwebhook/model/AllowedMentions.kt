package ua.vn.div.discordwebhook.model

import kotlinx.serialization.Serializable

@Serializable
data class AllowedMentions (
    val roles: List<String> = emptyList(),
    val users: List<String> = emptyList(),
    val parse: List<ParseType> = emptyList(),
) {
    enum class ParseType {
        everyone, roles, users
    }
}