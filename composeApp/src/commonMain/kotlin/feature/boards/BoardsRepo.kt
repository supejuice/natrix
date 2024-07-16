package feature.boards

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class BoardsRepoImpl(private val httpClient: HttpClient) : BoardsRepo {
    override suspend fun getBoards(): List<Board> {
        val response = httpClient.get("https://a.4cdn.org/boards.json").body<BoardsResponse>()
        return response.boards.map { Board(it.board, it.title) }
    }
}

interface BoardsRepo {
    suspend fun getBoards(): List<Board>
}

data class Board(
    val board: String,
    val title: String,
)