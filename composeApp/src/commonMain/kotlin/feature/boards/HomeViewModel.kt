package feature.boards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val boardsRepo: BoardsRepo
) : ViewModel() {

    private val _boards = MutableStateFlow<List<Board>>(emptyList())
    val boards: StateFlow<List<Board>> = _boards

    init {
        viewModelScope.launch {
            _boards.value = boardsRepo.getBoards()
        }
    }
}