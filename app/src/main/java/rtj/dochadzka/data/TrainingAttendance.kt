package rtj.dochadzka.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "attendance",
    primaryKeys = ["playerId", "trainingId"])
data class TrainingAttendance(
     val playerId: String,
     val trainingId: Int,
     val present: Boolean = true,
)