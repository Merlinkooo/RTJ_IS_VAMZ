package rtj.dochadzka.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import rtj.dochadzka.R
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState

enum class RTJAppScreen(@StringRes val title: Int) {
    Main(title = R.string.app_name),
    ScanAttendance(title = R.string.evidencia_dochadzka),
    ScanPayment(title = R.string.platba),
    Summary(title = R.string.evidencia_dochadzka),
    TrainingManagement(title = R.string.menazment_treningov)
}

@Composable
fun AppScreen(
    navController: NavHostController = rememberNavController()
) {

    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute =
        backStackEntry?.destination?.route

    val currentScreen =
        RTJAppScreen.values().find {
            it.name == currentRoute
        } ?: RTJAppScreen.Main

    Scaffold(
        topBar = {
            RTJAppBar(
                currentScreen = currentScreen,
                canNavigateBack = currentRoute != RTJAppScreen.Main.name,
                navigateBack = {
                    navController.navigate(RTJAppScreen.Main.name)
                }
            )
        }
    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = RTJAppScreen.Main.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = RTJAppScreen.Main.name){
                MainScreen(navController)
            }

            composable(route = RTJAppScreen.ScanPayment.name) {
                ScanScreen(
                    title = RTJAppScreen.ScanPayment.name,
                    isPayment = true
                )

            }

            composable(route = RTJAppScreen.Summary.name){
                SummaryScreen()
            }
            composable(route = RTJAppScreen.ScanAttendance.name){
                ScanScreen(
                    title = RTJAppScreen.ScanAttendance.name,
                    isPayment = false
                )
            }
            composable(route = RTJAppScreen.TrainingManagement.name){
                //TrainingManagementScreen()
            }

            }
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RTJAppBar(
    currentScreen: RTJAppScreen,
    canNavigateBack: Boolean,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(stringResource(currentScreen.title)) },
        colors = TopAppBarDefaults.mediumTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer
        ),
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.spat)
                    )
                }
            }
        }
    )
}