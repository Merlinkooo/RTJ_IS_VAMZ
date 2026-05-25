package rtj.dochadzka.ui

import android.app.TimePickerDialog
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import org.intellij.lang.annotations.JdkConstants
import rtj.dochadzka.R


data class Training(
    val date: String,
    val time: String
)
@Composable
fun TrainingList(trainings: List<Training>) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp)
    ) {

        items(trainings.count()) { training ->

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Dátum: ${trainings.get(training).date}")
                    Spacer(Modifier.padding(4.dp))
                    Text("Čas: ${trainings.get(training).time}")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrainingListPreview() {

    val trainings = listOf(

        Training(
            date = "25.05.2026",
            time = "18:00"
        ),

        Training(
            date = "26.05.2026",
            time = "10:30"
        ),

        Training(
            date = "27.05.2026",
            time = "07:15"
        )
    )

    TrainingList(trainings = trainings)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                onDateSelected(datePickerState.selectedDateMillis)
                onDismiss()
            }) {
                Text(stringResource(R.string.ok))
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(stringResource(R.string.spat))
            }
        }
    )
    {
        Column {
            DatePicker(state = datePickerState)

        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerModal(
    onTimeSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val timePickerState = rememberTimePickerState()

    Dialog(onDismissRequest = onDismiss) {
        Column {
            TimePicker(state = timePickerState)
            Row(horizontalArrangement = Arrangement.End){
                TextButton(onClick = onDismiss) {
                    Text(stringResource(R.string.spat))
                }
                TextButton(onClick = onDismiss) {
                    Text(stringResource(R.string.ok))
                }
            }
        }
    }
}

@Composable
fun TrainingManagementScreen() {

}



@Preview(showBackground = true)
@Composable
fun TrainingManagementScreenPreview() {

    TimePickerModal ({}, {})

}







