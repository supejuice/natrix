import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.compose.AppTheme
import navigation.BottomNav
import navigation.NavHost
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    AppTheme {
        Scaffold(
            bottomBar = { BottomNav() },
            content = { paddingValues ->
                NavHost()
            }
        )
    }
}