package org.skunkworks.project.presentation.screens.sollist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.skunkworks.project.domain.model.Sol
import org.skunkworks.project.domain.usecase.GetLatestSolsUseCase

data class SolListState(
    val sols: List<Sol> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

class SolListViewModel(
    private val getLatestSols: GetLatestSolsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SolListState())
    val state: StateFlow<SolListState> = _state.asStateFlow()

    init {
        loadSols()
    }

    fun loadSols() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true, error = null)
            getLatestSols()
                .onSuccess { sols ->
                    _state.value = _state.value.copy(sols = sols, isLoading = false)
                }
                .onFailure { e ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = e.message ?: "Unknown error"
                    )
                }
        }
    }
}