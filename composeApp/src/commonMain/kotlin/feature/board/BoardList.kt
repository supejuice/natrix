package feature.board

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import getPlatform

@Composable
fun BoardsList(
    onBoardClick: (String) -> Unit
) {
    val boardsRepo = getPlatform().container.boardsRepo
    val viewModel = viewModel { BoardsViewModel(boardsRepo) }
    val boards = viewModel.boards.collectAsState()
    LazyVerticalStaggeredGrid(
        modifier = Modifier.padding(16.dp),
        columns = StaggeredGridCells.Adaptive(150.dp),
        verticalItemSpacing = 4.dp,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        itemsIndexed(items = boards.value) { i, item ->
            Card(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    onBoardClick(item.board)
                }
            ) {
                Text(
                    text = item.title, modifier = Modifier
                        .requiredHeight(40.dp)
                        .padding(horizontal = 16.dp)
                        .clickable {
                            onBoardClick(item.board)
                        }, textAlign = TextAlign.Start)
            }
        }
    }

}