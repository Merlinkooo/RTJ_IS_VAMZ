package rtj.dochadzka.data

import android.os.Build

import rtj.dochadzka.ui.Child
import rtj.dochadzka.ui.Training
import java.time.LocalDate
import java.time.LocalTime

data class AppUiState (
    val children: List<Child> = listOf(),
    val trainings: List<Training> = listOf(),
    val selelctedTime : LocalTime = LocalTime.now(),
    val selectedDate : LocalDate = LocalDate.now(),
    val insertedName : String = "",
    val insertedSurname : String = "",
    val insertedID : String = ""
)