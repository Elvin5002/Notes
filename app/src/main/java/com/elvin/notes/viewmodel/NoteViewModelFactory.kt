package com.elvin.notes.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.elvin.notes.repository.NoteRepository

//(Application context and Repository) ViewModel-ə ötürməyə imkan verir
class NoteViewModelFactory(val app: Application, private val repository: NoteRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(app, repository) as T
    }
}