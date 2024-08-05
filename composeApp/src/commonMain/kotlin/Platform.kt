import core.AppContainer

interface Platform {
    val name: String
    val container: AppContainer
}

expect fun getPlatform(): Platform
fun getContainer() = getPlatform().container