package com.example.notescleanarch.feature_note.presentation.add_edit_note

data class NoteTextFieldState(
    val text: String = String(),
    val hint: String = String(),
    val isHintVisible: Boolean = true
)