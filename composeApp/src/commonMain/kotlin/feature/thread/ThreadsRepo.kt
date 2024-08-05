package feature.thread

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ThreadsRepoImpl(private val httpClient: HttpClient) : ThreadsRepo {
    override suspend fun getThreads(board: String, page: Int): Result<List<Thread>> = runCatching {
        val response =
            httpClient.get("https://a.4cdn.org/$board/$page.json").body<GetThreadsResponse>()
        response.threads.map {
            Thread(posts = it.posts.map { post ->
                val url = if (post.ext != null) "https://i.4cdn.org/$board/${post.tim}${post.ext}"
                else null
                Thread.Post(post.com, url)
            })
        }
    }
}

interface ThreadsRepo {
    suspend fun getThreads(board: String, page: Int): Result<List<Thread>>
}

data class Thread(
    val posts: List<Post>,
) {
    data class Post(
        val text: String?,
        val imageUrl: String?
    )

}