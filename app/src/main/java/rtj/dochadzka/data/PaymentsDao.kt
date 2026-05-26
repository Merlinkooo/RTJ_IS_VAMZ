package rtj.dochadzka.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface PaymentsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(payment: Payments)

    @Query("SELECT * FROM payments WHERE playerId = :p_playerId ")
    fun getPaymentsForPlayer(p_playerId: String) : Flow<List<Payments>>

    @Query("SELECT * FROM payments WHERE playerId = :month ")
    fun getPaymentsForMonth(month : Int) : Flow<List<Payments>>
}
