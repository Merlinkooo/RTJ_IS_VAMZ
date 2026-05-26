package rtj.dochadzka.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface TrainingAttendanceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(attendance: TrainingAttendance)

    @Query("SELECT * FROM attendance " +
            "JOIN TRAININGS ON trainingId = id " +
            "JOIN CHILDREN ON attendance.playerId = children.id " +
            "WHERE CAST(strftime('%m', trainings.date) AS INTEGER) = :month " +
            "AND attendance.playerId = :playerId " +
            "AND present = 1")
    fun getAttendanceForMonth(month : Int, playerId: String): Flow<List<TrainingAttendance>>

}