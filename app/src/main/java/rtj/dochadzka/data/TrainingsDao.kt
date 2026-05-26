package rtj.dochadzka.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface TrainingsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(training: Training)

    @Query("SELECT * FROM trainings")
    fun getAllTrainings() : Flow<List<Training>>

    @Query("SELECT * FROM children")
    fun getUpcomingTrainings() : Flow<List<Training>>
}