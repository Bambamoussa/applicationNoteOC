package com.openclassrooms.notes.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.openclassrooms.notes.data.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class NoteViewModel(private val notesRepository : NotesRepository ): ViewModel() {

    private val _notes: MutableStateFlow<List<Note>> = MutableStateFlow(emptyList())
    val notes: Flow<List<Note>> = _notes.asStateFlow()
    init {
        viewModelScope.launch {
            notesRepository.notes.collect {
                _notes.value = it
            }
        }
    }

}