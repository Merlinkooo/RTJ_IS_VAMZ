package rtj.dochadzka.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import rtj.dochadzka.R

data class Child(
    val id: Int,
    val name: String
)

data class TrainingAttendance(
    val date: String,
    val attended: Boolean
)


@Composable
fun ChildrenList(
    children: List<Child>,
    onChildClick: (Child) -> Unit
) {

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        items(children.count()) { index ->

            val child = children.get(index)
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onChildClick(child)
                    }
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = child.name,
                        style = MaterialTheme.typography.titleMedium
                    )

                    Text(">")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChildAttendanceScreen(
    childName: String,
    trainings: List<TrainingAttendance>
) {
    val children = listOf(
        "Jožko Mrkvička",
        "Milan Krátky",
        "Dávid Silný"
    )




    val months = listOf(
        "Január 2026",
        "Február 2026",
        "Marec 2026",
        "Apríl 2026",
        "Máj 2026"
    )

    var expanded by remember { mutableStateOf(false) }

    var selectedMonth by remember {
        mutableStateOf(months.last())
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = childName,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        // MONTH PICKER
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {

            OutlinedTextField(
                value = selectedMonth,
                onValueChange = {},
                readOnly = true,
                label = {
                    Text(text="Vyber mesiac")
                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {

                months.forEach { month ->

                    DropdownMenuItem(
                        text = {
                            Text(month)
                        },
                        onClick = {
                            selectedMonth = month
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "${stringResource(R.string.pocet_treningov)}:  / ${trainings.size}",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Prehľad tréningov",
            style = MaterialTheme.typography.titleLarge
        )

    }
}

@Composable
fun DetailAttendance(trainings : List<Training>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(trainings.count()) { index ->

            val training = trainings.get(index)
            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(training.date)

//                    Text(
//                        if ()
//                            "✓"
//                        else
//                            "✗"
//                    )
                }
            }
        }
    }
}
