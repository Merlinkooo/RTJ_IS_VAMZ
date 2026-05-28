package rtj.dochadzka.data

import kotlinx.coroutines.flow.Flow

class OfflinePaymentsRepository(private val paymentsDao: PaymentsDao) : PaymentsRepository  {

    override fun getPaymentsForPlayer(p_playerId: String): Flow<List<Payments>> {
        return paymentsDao.getPaymentsForPlayer(p_playerId)
    }

    override fun getPaymentsForMonth(month: Int): Flow<List<Payments>> {
        return paymentsDao.getPaymentsForMonth(month)
    }
}