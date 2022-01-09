package gst.trainingcourse_ex11_thaonx4.daggerhilt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import gst.trainingcourse_ex11_thaonx4.daggerhilt.database.entity.Note
import gst.trainingcourse_ex11_thaonx4.daggerhilt.repository.usercast.GetNoteUserCase
import gst.trainingcourse_ex11_thaonx4.daggerhilt.repository.usercast.UpdateNoteUserCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NoteViewModel @Inject constructor(
    private val getNoteUserCase: GetNoteUserCase,
    private val updateNoteUserCase: UpdateNoteUserCase,
) : ViewModel() {

    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>>
        get() = _notes

    fun insertNote(note: Note) {
        viewModelScope.launch {
            updateNoteUserCase.insertNote(note)
        }
    }

    fun getAll() {
        viewModelScope.launch {
            getNoteUserCase.getAllNote().catch { ex ->
                _notes.value = arrayListOf()
            }.collect { value ->
                _notes.value = value
            }
        }
    }
}