package rtj.dochadzka.ui




import android.graphics.drawable.Icon
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.sharp.Create
import androidx.compose.material.icons.sharp.Face
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import rtj.dochadzka.R


data class MenuItem(
    val title: String,
    val icon: ImageVector
)

@Composable
fun MainScreen(
    navController : NavController,
    modifier : Modifier = Modifier) {


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        AppButton(
                text = stringResource(R.string.platba),
                icon = Icons.Filled.ShoppingCart,
                onClick = { navController.navigate(RTJAppScreen.ScanPayment.name) }

            )

        Spacer(modifier = Modifier.height(32.dp))

        AppButton(
            text = stringResource(R.string.evidencia_dochadzka),
            icon = Icons.Outlined.DateRange,
            onClick = { navController.navigate(RTJAppScreen.ScanAttendance.name) }

        )

        Spacer(modifier = Modifier.height(32.dp))

        AppButton(
            text = stringResource(R.string.menu_statistika),
            icon = Icons.Outlined.Info,
            onClick = { navController.navigate(RTJAppScreen.Summary.name) }

        )

        Spacer(modifier = Modifier.height(32.dp))

        AppButton(
            text = stringResource(R.string.menazment_treningov),
            icon = Icons.Outlined.Add,
            onClick = { navController.navigate(RTJAppScreen.TrainingManagement.name) }

        )

    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {

        //MainScreen()

}

