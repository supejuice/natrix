package feature.board

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import getPlatform

@Composable
fun BoardsList(
    onBoardClick: (String) -> Unit
) {
    val boardsRepo = getPlatform().container.boardsRepo
    val viewModel = viewModel { BoardViewModel(boardsRepo) }
    val boards = viewModel.boards.collectAsState()
    LazyColumn {
        itemsIndexed(items = boards.value) { i, item ->
            Text(text = item.title, modifier = Modifier.clickable {
                onBoardClick(item.board)
            })
        }
    }

}