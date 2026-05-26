package rtj.dochadzka.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "attendance",
    primaryKeys = ["playerId", "trainingId"],
    foreignKeys = [
        ForeignKey(
            entity = Person::class,

            parentColumns = ["id"],

            childColumns = ["playerId"],

            onDelete = ForeignKey.CASCADE
        ) ,
        ForeignKey(
                entity = Training::class,

        parentColumns = ["id"],

        childColumns = ["trainingId"],

        onDelete = ForeignKey.CASCADE
)
    ])

data class TrainingAttendance(
     val playerId: String,
     val trainingId: Int,
     val present: Boolean = true,
)