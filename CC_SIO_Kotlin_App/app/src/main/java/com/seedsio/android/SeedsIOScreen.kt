package com.seedsio.android


//import androidx.lifecycle.viewmodel.compose.viewModel
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seedsio.android.ui.*
import kotlinx.coroutines.launch

//import androidx.navigation.compose.currentBackStackEntryAsState


enum class SeedsIOScreen(@StringRes val title: Int) {
    /*
    * Home,
    * MyGarden
    * PublicGarden
    * PublicSeedTrays
    *
    * */

    Home(title = R.string.home_page),
    MyGarden(title = R.string.my_garden),
    PublicGarden(title = R.string.public_garden),
    PublicSeedTrays(title = R.string.public_seed_tray)

}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeedsIoHomePage() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                /* Drawer content */
                Text("Pages", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Home Page") },
                    selected = false,
                    onClick = { /*
                    Navigate to the Home Page
                    */
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "My Garden") },
                    selected = false,
                    onClick = { /*
                    Navigate to My Garden page
                    */
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Public Garden") },
                    selected = false,
                    onClick = { /*
                    Navigate to the Public Garden
                    */
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Public Seed Trays") },
                    selected = false,
                    onClick = { /*
                    Navigate to Public Seed Trays
                    */
                    }
                )
            }
        },
    )
    {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Show drawer") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "Llamas") },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    }
                )
            }
        )
        {
            Column(
//                modifier = modifier,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                Image(
                    painter = painterResource(R.drawable.seedsio_logo_m),
                    contentDescription = null,
                    modifier = Modifier.width(300.dp)
                )
                Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.headlineSmall
                )
                Button(onClick = { /*TODO*/ }) {
                    Text(stringResource(R.string.login_button))
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun SeedsIOAppBar(
    currentScreen: SeedsIOScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
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
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}

@Composable
fun SeedsIOApp(

) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Image(
                painter = painterResource(R.drawable.seedsio_logo_m),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
            Text(
                text = stringResource(R.string.my_garden),
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
        }
        Row(modifier = Modifier.weight(1f, false)) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(id = R.dimen.padding_medium)
                )
            )
            {

            }
        }
    }
}
@Preview
@Composable
fun HomePagePreview() {
    SeedsIoHomePage()
}