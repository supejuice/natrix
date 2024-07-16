package feature.boards

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import getPlatform

@Composable
fun BoardsList() {
    val boardsRepo = getPlatform().container.boardsRepo
    val viewModel = viewModel { HomeViewModel(boardsRepo) }
    LazyColumn {
        items(items = viewModel.boards.value) { board ->
            BoardItem(board = board)
        }
    }
}

@Composable
private fun BoardItem(board: Board) {
    Text(text = board.title)
}