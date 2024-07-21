package screen

import androidx.compose.runtime.Composable
import feature.board.BoardsList

@Composable
fun HomeScreen(
    onBoardClick: (String) -> Unit
) {
    BoardsList(onBoardClick)
}