import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import feature.thread.Thread

@Composable
fun ThreadList(threads: List<Thread>) {
    LazyVerticalStaggeredGrid(
        modifier = Modifier.fillMaxSize(),
        columns = StaggeredGridCells.Adaptive(150.dp),
    ) {

        items(threads.size) { index ->
            ThreadItem(threads[index])
        }
    }
}

@Composable
fun ThreadItem(thread: Thread) {

}
