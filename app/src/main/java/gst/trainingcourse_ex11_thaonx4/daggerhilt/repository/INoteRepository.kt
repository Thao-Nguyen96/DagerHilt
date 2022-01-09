package gst.trainingcourse_ex11_thaonx4.daggerhilt.repository

import gst.trainingcourse_ex11_thaonx4.daggerhilt.database.entity.Note
import kotlinx.coroutines.flow.Flow

interface INoteRepository {

    suspend fun insertNote(note:Note)

    fun getAll(): Flow<List<Note>>
}