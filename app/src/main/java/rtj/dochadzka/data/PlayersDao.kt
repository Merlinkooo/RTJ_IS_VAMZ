package rtj.dochadzka.data

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

interface PlayersDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(player: Person)

    @Delete
    suspend fun delete(player_id: String)

    @Query("SELECT * FROM children")
    fun getAllPlayers() : Flow<List<Person>>
}
