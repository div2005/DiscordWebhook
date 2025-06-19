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

    suspend fun sendMessage(url: String, webhookMessage: WebhookMessage): HttpResponse? {
        val json = Json.encodeToString(webhookMessage)

        if (url.isEmpty()) return null

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