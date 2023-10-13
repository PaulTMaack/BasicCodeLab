package com.seedsio.android


import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.seedsio.android.ui.*
import kotlinx.coroutines.launch


enum class SeedsIOScreen(@StringRes val title: Int) {
    Home(title = R.string.home_page),
    AllPlants(title = R.string.my_plants),
    AddPlant(title = R.string.add_plants),
    MySeedTrays(title = R.string.my_seed_trays),
    GardenShed(title = R.string.my_garden_shed),
    PublicGarden(title = R.string.public_garden),
    PublicSeedTrays(title = R.string.public_seed_tray),
}



//@ExperimentalMaterial3Api
//@Composable
//fun SeedsIOAppBar(
//    currentScreen: SeedsIOScreen,
//    canNavigateBack: Boolean,
//    navigateUp: () -> Unit = {},
//    modifier: Modifier = Modifier
//) {


//    TopAppBar(
//        title = { Text(stringResource(currentScreen.title)) },
//        colors = TopAppBarDefaults.mediumTopAppBarColors(
//            containerColor = MaterialTheme.colorScheme.primaryContainer
//        ),
//        modifier = modifier,
//        navigationIcon = {
//            if (canNavigateBack) {
//                IconButton(onClick = navigateUp) {
//                    Icon(
//                        imageVector = Icons.Filled.ArrowBack,
//                        contentDescription = stringResource(R.string.back_button)
//                    )
//                }
//            }
//        }
//    )
//}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SeedsIoHomePage(
    navController: NavHostController = rememberNavController()
) {

    val publicItems = listOf(
        NavigationItem(
            title = SeedsIOScreen.Home.title,
            selectedIcon = Icons.Default.Menu,
            unselectedIcon = Icons.Default.Menu,
            route = SeedsIOScreen.Home.name
        ),
//        NavigationItem(
//            title = "All Plants",
//            selectedIcon = Icons.Default.Home,
//            unselectedIcon = Icons.Default.Home,
//            route = SeedsIOScreen.AllPlants.name
//        ),
//        NavigationItem(
//            title = "Add Plant",
//            selectedIcon = Icons.Default.AccountBox,
//            unselectedIcon = Icons.Default.AccountBox,
//            route = SeedsIOScreen.AddPlant.name
//        ),
//        NavigationItem(
//            title = "Seed Trays",
//            selectedIcon = Icons.Default.AccountCircle,
//            unselectedIcon = Icons.Default.AccountCircle,
//            route = SeedsIOScreen.MySeedTrays.name
//        ),
//        NavigationItem(
//            title = "Garden Shed",
//            selectedIcon = Icons.Default.Build,
//            unselectedIcon = Icons.Default.Build,
//            route = SeedsIOScreen.GardenShed.name
//
//        ),
        NavigationItem(
            title = SeedsIOScreen.PublicGarden.title,
            selectedIcon = Icons.Default.Home,
            unselectedIcon = Icons.Default.Home,
            route = SeedsIOScreen.PublicGarden.name
        ),
        NavigationItem(
            title = SeedsIOScreen.PublicSeedTrays.title,
            selectedIcon = Icons.Default.Home,
            unselectedIcon = Icons.Default.Home,
            route = SeedsIOScreen.PublicSeedTrays.name
        ),
    )
    val privateItems = listOf(
//        NavigationItem(
//            title = "Home",
//            selectedIcon = Icons.Default.Menu,
//            unselectedIcon = Icons.Default.Menu,
//            route = SeedsIOScreen.Home.name
//        ),
        NavigationItem(
            title = SeedsIOScreen.AllPlants.title,
            selectedIcon = Icons.Default.Home,
            unselectedIcon = Icons.Default.Home,
            route = SeedsIOScreen.AllPlants.name
        ),
        NavigationItem(
            title = SeedsIOScreen.AddPlant.title,
            selectedIcon = Icons.Default.AccountBox,
            unselectedIcon = Icons.Default.AccountBox,
            route = SeedsIOScreen.AddPlant.name
        ),
        NavigationItem(
            title = SeedsIOScreen.MySeedTrays.title,
            selectedIcon = Icons.Default.AccountCircle,
            unselectedIcon = Icons.Default.AccountCircle,
            route = SeedsIOScreen.MySeedTrays.name
        ),
        NavigationItem(
            title = SeedsIOScreen.GardenShed.title,
            selectedIcon = Icons.Default.Build,
            unselectedIcon = Icons.Default.Build,
            route = SeedsIOScreen.GardenShed.name

        ),
//        NavigationItem(
//            title = "Public Garden",
//            selectedIcon = Icons.Default.Home,
//            unselectedIcon = Icons.Default.Home,
//            route = SeedsIOScreen.PublicGarden.name
//        ),
//        NavigationItem(
//            title = "Public Seed Trays",
//            selectedIcon = Icons.Default.Home,
//            unselectedIcon = Icons.Default.Home,
//            route = SeedsIOScreen.PublicSeedTrays.name
//        ),
    )
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    // icons to mimic drawer destinations
    //val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
//    val selectedItem = remember { mutableStateOf(0) }
    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                Text("Public", modifier = Modifier.padding(16.dp))
                publicItems.forEachIndexed { index, item ->
                    NavigationDrawerItem(
//                        label = { Text(text = item.title)},
                        label = {item.title},
                        selected = index == selectedItemIndex,
                        onClick = {
                            navController.navigate(route = (item.route))
                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = (if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon),
                                contentDescription = item.route
                            )
                        },
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
                Text("Private", modifier = Modifier.padding(16.dp))
                privateItems.forEachIndexed { index, item ->
                    NavigationDrawerItem(
//                        label = { Text(text = item.title)},
                        label = { item.title},
                        selected = index == selectedItemIndex,
                        onClick = {
                            navController.navigate(route = (item.route))
                            selectedItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = (if (index == selectedItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon),
                                contentDescription = item.route
                            )
                        },
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        },
        gesturesEnabled = true,
        drawerState = drawerState

    ) {
        Scaffold {

                TopAppBar(
                    title = {
                        Text(text = "SeedsIO")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Navigation Menu"
                            )
                        }
                    }
                )

        }

    }

        NavHost(
            navController = navController,
            startDestination = SeedsIOScreen.Home.name,
            modifier = Modifier.padding(16.dp)
        )
        {
            composable(route = SeedsIOScreen.Home.name){
                HomeScreen(
//                    onNextButtonClicked = {
//                        navController.navigate(SeedsIOScreen.Home.name)
//                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = SeedsIOScreen.AllPlants.name){
                AllPlants(
//                    onNextButtonClicked = {
////                        navController.navigate(SeedsIOScreen.AllPlants.name)
//                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = SeedsIOScreen.AddPlant.name){
                AddPlant(
//                    onNextButtonClicked = {
////                        navController.navigate(SeedsIOScreen.AddPlant.name)
//                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = SeedsIOScreen.MySeedTrays.name){
                MySeedTrays(
//                    onNextButtonClicked = {
////                        navController.navigate(SeedsIOScreen.MySeedTrays.name)
//                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = SeedsIOScreen.GardenShed.name){
                GardenShed(
//                    onNextButtonClicked = {
////                        navController.navigate(SeedsIOScreen.GardenShed.name)
//                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = SeedsIOScreen.PublicGarden.name){
                PublicGarden(
//                    onNextButtonClicked = {
////                        navController.navigate(SeedsIOScreen.PublicGarden.name)
//                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }
            composable(route = SeedsIOScreen.PublicSeedTrays.name){
                PublicSeedTrays(
//                    onNextButtonClicked = {
////                        navController.navigate(SeedsIOScreen.PublicSeedTrays.name)
//                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.padding_medium))
                )
            }

        }
}

//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentScreen = SeedsIOScreen.valueOf(
//        backStackEntry?.destination?.route ?: SeedsIOScreen.Home.name
//    )

//        { innerPadding ->
//
//        }

//    Scaffold(
//        topBar = {
//            SeedsIOAppBar(
//                currentScreen = currentScreen,
//                canNavigateBack = navController.previousBackStackEntry != null,
//                navigateUp = { navController.navigateUp() }
//            )
//        }
//        /*        floatingActionButton = {
//        //            ExtendedFloatingActionButton(
//        //                text = { Text("Show drawer") },
//        //                icon = { Icon(Icons.Filled.Add, contentDescription = "Llamas") },
//        //                onClick = {
//        //                    scope.launch {
//        //                        drawerState.apply {
//        //                            if (isClosed) open() else close()
//        //                        }
//        //                    }
//        //                }
//        //            )
//               }*/
//    )
//    { innerPadding ->
////        val uiState by viewModel.uiState.collectAsState()
////        NavHost(
////            navController = navController,
////            startDestination = SeedsIOScreen.Home.name,
////            modifier = Modifier.padding(innerPadding)
////        )
////        {
////            composable(route = SeedsIOScreen.Home.name){
////                HomeScreen(
//////                    quantityOptions = DataSource.quantityOptions,
////                    onNextButtonClicked = {
//////                        viewModel.setQuantity(it)
////                        navController.navigate(SeedsIOScreen.Home.name)
////                    },
////                    modifier = Modifier
////                        .fillMaxSize()
////                        .padding(dimensionResource(R.dimen.padding_medium))
////                )
////            }
////        }
////        Column(
//////                modifier = modifier,
////            verticalArrangement = Arrangement.SpaceBetween
////        ) {
////            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
////            Image(
////                painter = painterResource(R.drawable.seedsio_logo_m),
////                contentDescription = null,
////                modifier = Modifier.width(300.dp)
////            )
////            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
////            Text(
////                text = stringResource(R.string.app_name),
////                style = MaterialTheme.typography.headlineSmall
////            )
////            Button(onClick = { /*TODO*/ }) {
////                Text(stringResource(R.string.login_button))
////            }
////        }
//    }




//@Composable
//fun SeedsIOApp(
//
//) {
//    Column(
//        verticalArrangement = Arrangement.SpaceBetween
//    ) {
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
//        ) {
//            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
//            Image(
//                painter = painterResource(R.drawable.seedsio_logo_m),
//                contentDescription = null,
//                modifier = Modifier.width(300.dp)
//            )
//            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
//            Text(
//                text = stringResource(R.string.my_garden),
//                style = MaterialTheme.typography.headlineSmall
//            )
//            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_small)))
//        }
//        Row(modifier = Modifier.weight(1f, false)) {
//            Column(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.spacedBy(
//                    dimensionResource(id = R.dimen.padding_medium)
//                )
//            )
//            {
//
//            }
//        }
//    }
//}

@Preview
@Composable
fun HomePagePreview() {
    SeedsIoHomePage()
}

//@Composable
//fun ModalNavigationDrawerSample() {
////    val drawerState = rememberDrawerState(DrawerValue.Closed)
////    val scope = rememberCoroutineScope()
////    // icons to mimic drawer destinations
////    val items = listOf(Icons.Default.Favorite, Icons.Default.Face, Icons.Default.Email)
////    val selectedItem = remember { mutableStateOf(items[0]) }
////    ModalNavigationDrawer(
////        drawerState = drawerState,
////        drawerContent = {
////            ModalDrawerSheet {
////                Spacer(Modifier.height(12.dp))
////                items.forEach { item ->
////                    NavigationDrawerItem(
////                        icon = { Icon(item, contentDescription = null) },
////                        label = { Text(item.name) },
////                        selected = item == selectedItem.value,
////                        onClick = {
////                            scope.launch { drawerState.close() }
////                            selectedItem.value = item
////                        },
////                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
////                    )
////                }
////            }
////        },
////        content = {
////            Column(
////                modifier = Modifier
////                    .fillMaxSize()
////                    .padding(16.dp),
////                horizontalAlignment = Alignment.CenterHorizontally
////            ) {
////                Text(text = if (drawerState.isClosed) ">>> Swipe >>>" else "<<< Swipe <<<")
////                Spacer(Modifier.height(20.dp))
////                Button(onClick = { scope.launch { drawerState.open() } }) {
////                    Text("Click to open")
////                }
////            }
////        }
////    )
//}