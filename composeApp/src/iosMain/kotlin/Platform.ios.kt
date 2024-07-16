import di.AppContainer
import platform.UIKit.UIDevice
import io.ktor.client.engine.darwin.*

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val container: AppContainer = AppContainer(Darwin)
}

actual fun getPlatform(): Platform = IOSPlatform()