package gst.trainingcourse_ex11_thaonx4.daggerhilt.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import gst.trainingcourse_ex11_thaonx4.daggerhilt.utils.Constants
import kotlinx.parcelize.Parcelize

@Entity(tableName = Constants.NOTE_TABLE)
@Parcelize
data class Note(
    @ColumnInfo(name = Constants.ID_COLUMN)
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = Constants.NAME_COLUMN)
    var title: String = Constants.EMPTY,

    @ColumnInfo(name = Constants.DESCRIPTION)
    var description: String = Constants.EMPTY,
) : Parcelable