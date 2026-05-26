package rtj.dochadzka.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "payments",
    foreignKeys = [
        ForeignKey(
            entity = Person::class,

            parentColumns = ["id"],

            childColumns = ["playerId"],

            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Payments(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val playerId: Int,

    val amount: Double,

    val paymentDate: Long,

    val month: Int,

)
