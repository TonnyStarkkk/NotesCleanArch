package com.example.notescleanarch.di

import androidx.room.Room
import com.example.notescleanarch.feature_note.data.data_source.NoteDatabase
import com.example.notescleanarch.feature_note.data.repository.NoteRepositoryImpl
import com.example.notescleanarch.feature_note.domain.repository.NoteRepository
import com.example.notescleanarch.feature_note.domain.use_case.AddNote
import com.example.notescleanarch.feature_note.domain.use_case.DeleteNote
import com.example.notescleanarch.feature_note.domain.use_case.GetNote
import com.example.notescleanarch.feature_note.domain.use_case.GetNotes
import com.example.notescleanarch.feature_note.domain.use_case.NoteUseCases
import com.example.notescleanarch.feature_note.presentation.add_edit_note.AddEditNoteViewModel
import com.example.notescleanarch.feature_note.presentation.notes.components.NotesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val appModule: Module = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    single { get<NoteDatabase>().noteDao }

    single { get<NoteRepository>() }

    single { get<NoteRepositoryImpl>() }

    factory {
        NoteUseCases( get(), get(), get(), get())
    }

    factory { get<AddEditNoteViewModel>() }

    factory { get<NotesViewModel>() }
}