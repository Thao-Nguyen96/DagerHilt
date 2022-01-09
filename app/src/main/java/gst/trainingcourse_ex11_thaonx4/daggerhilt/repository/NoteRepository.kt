package gst.trainingcourse_ex11_thaonx4.daggerhilt.repository

import gst.trainingcourse_ex11_thaonx4.daggerhilt.database.NoteDao
import gst.trainingcourse_ex11_thaonx4.daggerhilt.database.entity.Note
import gst.trainingcourse_ex11_thaonx4.daggerhilt.utils.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject


class NoteRepository @Inject constructor(
    private val noteDao: NoteDao,
    private val dispatcherProvider: DispatcherProvider,
) : INoteRepository {
    override suspend fun insertNote(note: Note) {
        return withContext(dispatcherProvider.io) {
            noteDao.insertNote(note)
        }
    }
//
    override fun getAll(): Flow<List<Note>> {
        return noteDao.getAllNote().flowOn(dispatcherProvider.io)
    }
}