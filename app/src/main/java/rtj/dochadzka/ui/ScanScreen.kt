package rtj.dochadzka.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import rtj.dochadzka.R

@Composable
fun ScanScreen(
    title: String,
    isPayment : Boolean,
    modifier: Modifier = Modifier
) {

    Text( text = stringResource(R.string.prilozit_kartu))
}

@Preview(showBackground = true)
@Composable
fun ScanScreenPreview() {
    ScanScreen(
        title = "Platba",
        isPayment = true)
}