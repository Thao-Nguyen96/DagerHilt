package gst.trainingcourse_ex11_thaonx4.daggerhilt.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import gst.trainingcourse_ex11_thaonx4.daggerhilt.database.entity.Note
import gst.trainingcourse_ex11_thaonx4.daggerhilt.utils.Constants

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

    companion object {

        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Room.databaseBuilder(context.applicationContext,
                NoteDatabase::class.java,
                Constants.DATABASE_NAME
            ).build()
                .also {
                    INSTANCE = it
                }
        }
    }
}