package screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import natrix_4chanreader.composeapp.generated.resources.Res
import natrix_4chanreader.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeScreen(
    onBoardClick: (String) -> Unit
) {
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 42.dp)
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            Text(
                stringResource(Res.string.app_name),
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(modifier = Modifier.width(5.dp))
            BlinkingCursor()
        }
    }
}

@Composable
private fun BlinkingCursor() {
    val alpha = remember { Animatable(1f) }
    LaunchedEffect(Unit) {
        while (true) {
            alpha.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 500)
            )
            alpha.animateTo(
                targetValue = 1f,
                animationSpec = tween(durationMillis = 500)
            )
        }
    }
    Text(
        text = "█",
        style = MaterialTheme.typography.headlineLarge,
        modifier = Modifier
            .alpha(alpha.value),
        color = MaterialTheme.colorScheme.onBackground // Set the cursor color here
    )
}