package di

import feature.boards.BoardsRepo
import feature.boards.BoardsRepoImpl
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.handleCoroutineException
import kotlinx.serialization.json.Json

class AppContainer(private val httpEngine: HttpClientEngineFactory<*>) {
    private val httpClient: HttpClient by lazy {
        HttpClient(httpEngine) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
            HttpResponseValidator {
                handleResponseExceptionWithRequest { cause, request ->  }
                validateResponse {  }
            }
        }
    }
    val boardsRepo: BoardsRepo by lazy { BoardsRepoImpl(httpClient) }
}