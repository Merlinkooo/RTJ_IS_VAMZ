package rtj.dochadzka

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import rtj.dochadzka.data.Person

interface PlayersDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(player: Person)
}