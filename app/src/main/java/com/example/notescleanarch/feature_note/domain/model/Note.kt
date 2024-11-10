package com.example.notescleanarch.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notescleanarch.ui_theme.BabyBlue
import com.example.notescleanarch.ui_theme.LightGreen
import com.example.notescleanarch.ui_theme.RedOrange
import com.example.notescleanarch.ui_theme.RedPink
import com.example.notescleanarch.ui_theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: String,
    val color: Int,
    @PrimaryKey(autoGenerate = true) var id: Int = 0
) {
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException(message: String): Exception(message)