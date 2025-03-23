package com.garnegsoft.ofinance.ui.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.garnegsoft.ofinance.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    initialTabIndex: Int = 1,
) {
    val pagerState = rememberPagerState(initialPage = initialTabIndex) { 3 }
    val scrollScope = rememberCoroutineScope()
    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    pagerState.currentPage == 0,
                    label = { Text("Отчёт") },
                    icon = {
                        if (pagerState.currentPage == 0){
                            Icon(painter = painterResource(R.drawable.insert_chart_filled), contentDescription = null)
                        } else {
                            Icon(painter = painterResource(R.drawable.insert_chart_outlined), contentDescription = null)
                        }

                    },
                    onClick = {
                        scrollScope.launch {
                            pagerState.scrollToPage(0)
                        }
                    }
                )

                NavigationBarItem(
                    selected = pagerState.currentPage == 1,
                    label = { Text("Главная") },
                    icon = {
                        if (pagerState.currentPage == 1) {
                            Icon(imageVector = Icons.Filled.Home, contentDescription = null)
                        } else {
                            Icon(imageVector = Icons.Outlined.Home, contentDescription = null)
                        }
                    },
                    onClick = {
                        scrollScope.launch {
                            pagerState.scrollToPage(1)
                        }
                    }
                )

                NavigationBarItem(
                    selected = pagerState.currentPage == 2,
                    label = { Text("История") },
                    icon = {
                        Icon(painterResource(R.drawable.history), contentDescription = null)
                    },
                    onClick = {
                        scrollScope.launch {
                            pagerState.scrollToPage(2)
                        }
                    }
                )
            }
        }
    ) {
        HorizontalPager(
            modifier = Modifier.padding(it),
            state = pagerState,
            userScrollEnabled = false,

            ) { page ->
            when(page) {
                0 -> {}
                1 -> HomeTab()
                2 -> {}
            }
        }
    }

}


@Composable
fun MainScreenItemTitle(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = text,
        style = MaterialTheme.typography.headlineSmall,
        color = MaterialTheme.colorScheme.onBackground
    )
}

@Composable
fun ContainerListItem(
    vaultTitle: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    ) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.small)
            .clickable(onClick = onClick)
            .padding(8.dp)

    ) {
        Text(
            text = vaultTitle,
            style = MaterialTheme.typography.titleMedium
        )
    }
}