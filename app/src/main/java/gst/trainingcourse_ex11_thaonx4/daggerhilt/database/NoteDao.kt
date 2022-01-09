package gst.trainingcourse_ex11_thaonx4.daggerhilt.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import gst.trainingcourse_ex11_thaonx4.daggerhilt.database.entity.Note
import gst.trainingcourse_ex11_thaonx4.daggerhilt.utils.Constants
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM ${Constants.NOTE_TABLE}")
    fun getAllNote(): Flow<List<Note>>
}