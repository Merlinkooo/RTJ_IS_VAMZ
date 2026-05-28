package rtj.dochadzka.data

import kotlinx.coroutines.flow.Flow

interface PaymentsRepository {

    fun getPaymentsForPlayer(p_playerId: String) : Flow<List<Payments>>

    fun getPaymentsForMonth(month : Int) : Flow<List<Payments>>

}