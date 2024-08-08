package ua.vn.div.discordwebhook

import io.ktor.client.*
import io.ktor.client.engine.java.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ua.vn.div.discordwebhook.model.*

class DiscordWebhook {
    private val URL_PATTERN = Regex("https?:\\/\\/discord.com\\/api\\/webhooks\\/([^\\/]+)\\/([^\\/]+)")

    private val client = HttpClient(Java) {
        engine {
            protocolVersion = java.net.http.HttpClient.Version.HTTP_2
        }
    }

    suspend fun sendMessage(url: String, message: Message): HttpResponse? {
        val json = Json.encodeToString(message)

        if (!URL_PATTERN.matches(url)) return null

        try {
            return client.post(url) {
                contentType(ContentType.Application.Json)
                setBody(json)
            }
        } catch (e: Exception) {
            throw e
        }
    }
}