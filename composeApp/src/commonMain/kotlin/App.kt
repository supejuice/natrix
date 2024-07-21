import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.compose.AppTheme
import navigation.NavHost
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App() {
    AppTheme {
        Scaffold(
            bottomBar = { },
            content = { paddingValues ->
                NavHost()
            }
        )
    }
}