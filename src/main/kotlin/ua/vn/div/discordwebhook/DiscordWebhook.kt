package ua.vn.div.discordwebhook

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import ua.vn.div.discordwebhook.model.*

class DiscordWebhook(
    val httpClient: HttpClient = HttpClient(OkHttp) {
        engine {
            config {
                followRedirects(true)
            }
        }
    }
) {
    private val URL_PATTERN = Regex("https?:\\/\\/discord.com\\/api\\/webhooks\\/([^\\/]+)\\/([^\\/]+)")

    suspend fun sendMessage(url: String, message: Message): HttpResponse? {
        val json = Json.encodeToString(message)

        if (!URL_PATTERN.matches(url)) return null

        try {
            return httpClient.post(url) {
                contentType(ContentType.Application.Json)
                setBody(json)
            }
        } catch (e: Exception) {
            throw e
        }
    }
}