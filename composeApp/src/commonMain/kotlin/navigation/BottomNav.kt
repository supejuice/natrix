package navigation

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import natrix_4chanreader.composeapp.generated.resources.Res
import natrix_4chanreader.composeapp.generated.resources.home
import natrix_4chanreader.composeapp.generated.resources.newspaper
import org.jetbrains.compose.resources.painterResource

@Composable
fun BottomNav() = BottomAppBar {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            icon = { Icon(painterResource(Res.drawable.home), contentDescription = null) },
            label = { Text("Home") },
            onClick = { }
        )
        NavigationBarItem(
            selected = true,
            icon = { Icon(painterResource(Res.drawable.newspaper), contentDescription = null) },
            label = { Text("HackerNews") },
            onClick = { }
        )
    }
}