package screen

import ThreadList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import feature.thread.ThreadsViewModel
import getContainer

@Composable
fun ThreadsScreen(boardName: String) {
    val viewModel = viewModel { ThreadsViewModel(getContainer().threadsRepo, boardName) }
    ThreadList(viewModel.threadsLiveData.collectAsState().value)
}