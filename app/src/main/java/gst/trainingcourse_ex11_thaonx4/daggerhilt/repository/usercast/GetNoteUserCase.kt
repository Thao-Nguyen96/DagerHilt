package gst.trainingcourse_ex11_thaonx4.daggerhilt.repository.usercast

import gst.trainingcourse_ex11_thaonx4.daggerhilt.database.entity.Note
import gst.trainingcourse_ex11_thaonx4.daggerhilt.repository.INoteRepository
import gst.trainingcourse_ex11_thaonx4.daggerhilt.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNoteUserCase @Inject constructor(private val noteRepository: INoteRepository) {

    fun getAllNote(): Flow<List<Note>> = noteRepository.getAll()
}