package gst.trainingcourse_ex11_thaonx4.daggerhilt.repository.usercast

import gst.trainingcourse_ex11_thaonx4.daggerhilt.database.entity.Note
import gst.trainingcourse_ex11_thaonx4.daggerhilt.repository.INoteRepository
import gst.trainingcourse_ex11_thaonx4.daggerhilt.repository.NoteRepository
import javax.inject.Inject

class UpdateNoteUserCase @Inject constructor(private val noteRepository: INoteRepository) {

    suspend fun insertNote(note: Note) = noteRepository.insertNote(note)
}