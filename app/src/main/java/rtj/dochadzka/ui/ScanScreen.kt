package rtj.dochadzka.ui


import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import rtj.dochadzka.R

@Composable
fun NfcScanScreen(
    title: String,
    isPayment : Boolean
) {

    Text( text = stringResource(R.string.prilozit_kartu))
}

@Preview(showBackground = true)
@Composable
fun ScanScreenPreview() {
    NfcScanScreen(
        title = "Platba",
        isPayment = true)
}