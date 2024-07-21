import core.AppContainer
import io.ktor.client.engine.darwin.Darwin
import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val container: AppContainer = AppContainer(Darwin)
}

actual fun getPlatform(): Platform = IOSPlatform()