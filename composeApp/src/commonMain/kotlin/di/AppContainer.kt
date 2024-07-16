package di

import io.ktor.client.HttpClient
import feature.boards.BoardsRepoImpl
import feature.boards.BoardsRepo
import io.ktor.client.engine.HttpClientEngineFactory
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*

class AppContainer(private val httpEngine: HttpClientEngineFactory<*>) {
    private val httpClient: HttpClient by lazy {
        HttpClient(httpEngine) {
            install(ContentNegotiation) {
                json()
            }
        }
    }
    val boardsRepo: BoardsRepo by lazy { BoardsRepoImpl(httpClient) }
}