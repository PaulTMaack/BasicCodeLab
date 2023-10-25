package com.seedsio.android.ui

/*
* News> Text|Text(Marquee) // https://medium.com/@theAndroidDeveloper/jetpack-compose-gets-official-support-for-marquee-heres-how-to-use-it-1f678aecb851
* (Reusable) SearchBar>TextInput|SearchButton|ClearButton|ShowFollowedButton
* (Reusable) ResultsBar>Text|Text|Dropdown|Text
* ResultsTable>Plant Variety (Hypertext)|Gardeners (Text(Int)) |Plants Grown (Text(Int))|Recent Image (Image)|# Notes (Text(Int))|Last Note (DateTime)|Genus & Species (Text)
* (Reusable) ResultsBar>Text|Text|Dropdown|Text
* */


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.seedsio.android.R


@Composable
fun HomeScreen(
//    quantityOptions: List<Pair<Int, Int>>, //TODO: Update this.
//    onNextButtonClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
        ) {
            Image(
                painter = painterResource(R.drawable.seedsio_logo_m),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
            )
            Spacer(modifier = Modifier.height(dimensionResource(R.dimen.padding_medium)))
//            Text(
//                stringResource(R.string.home_page),
//                style = MaterialTheme.typography.headlineLarge
//            )
            Text(
                stringResource(R.string.by_chillichump),
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
            ) {
//                quantityOptions.forEach { item ->
//                    SelectQuantityButton(
//                        labelResourceId = item.first,
//                        onClick = { onNextButtonClicked(item.second) }
//                    )
//                }
            }
        }
    }
}

//**
// * Customizable button composable that displays the [labelResourceId]
// * and triggers [onClick] lambda when this composable is clicked
// *
//@Composable
//fun SelectQuantityButton(
//    @StringRes labelResourceId: Int,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier
//) {
//    Button(
//        onClick = onClick,
//        modifier = modifier.widthIn(min = 250.dp)
//    ) {
//        Text(stringResource(labelResourceId))
//    }
//}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
//        quantityOptions = DataSource.quantityOptions,
//        onNextButtonClicked = {},
        modifier = Modifier
            .fillMaxSize()
            .padding(dimensionResource(R.dimen.padding_medium))
    )
}
