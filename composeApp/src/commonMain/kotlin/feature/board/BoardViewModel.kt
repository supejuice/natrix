package feature.board

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class BoardViewModel(
    private val boardsRepo: BoardsRepo
) : ViewModel() {

    private val _boards = MutableStateFlow<List<Board>>(emptyList())
    val boards: StateFlow<List<Board>> = _boards

    init {
        viewModelScope.launch {
            val result = boardsRepo.getBoards()
            _boards.value = result.getOrNull() ?: emptyList()
        }
    }
}