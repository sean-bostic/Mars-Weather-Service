package org.skunkworks.project.presentation.screens.soldetail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.skunkworks.project.domain.model.Sol

class SolDetailViewModel : ViewModel() {

    private val _sol = MutableStateFlow<Sol?>(null)
    val sol: StateFlow<Sol?> = _sol.asStateFlow()

    fun setSol(sol: Sol) {
        _sol.value = sol
    }
}