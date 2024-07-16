import android.os.Build
import di.AppContainer
import io.ktor.client.engine.cio.CIO

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
    override val container: AppContainer = AppContainer(CIO)
}

actual fun getPlatform(): Platform = AndroidPlatform()