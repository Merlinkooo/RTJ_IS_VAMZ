package rtj.dochadzka.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Person::class, Training::class, TrainingAttendance::class, Payments::class], version = 1, exportSchema = false)
abstract class RTJAppDatabase : RoomDatabase() {
    abstract fun playersDao(): PlayersDao
    abstract fun trainingsDao(): TrainingsDao
    abstract fun trainingAttendanceDao(): TrainingAttendanceDao
    abstract fun paymentsDao(): PaymentsDao

    companion object {
        @Volatile
        private var INSTANCE: RTJAppDatabase? = null

        fun getDatabase(context: Context): RTJAppDatabase {

            return INSTANCE ?: synchronized(this) {
                val instance =
                    Room.databaseBuilder(context, RTJAppDatabase::class.java, "rtj_app_database")
                        .fallbackToDestructiveMigration()
                        .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
