package feature.thread

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThreadsViewModel(
    private val threadsRepo: ThreadsRepo,
    private val boardName: String
) : ViewModel() {
    private val _threadsLiveData = MutableStateFlow<List<Thread>>(emptyList())
    val threadsLiveData: StateFlow<List<Thread>> = _threadsLiveData

    init {
        fetch()
    }

    private var pages = 0

    fun fetch() {
        pages++
        viewModelScope.launch {
            threadsRepo.getThreads(boardName, pages).onSuccess {
                val newList = ArrayList(_threadsLiveData.value)
                newList.addAll(it)
            }
        }
    }
}