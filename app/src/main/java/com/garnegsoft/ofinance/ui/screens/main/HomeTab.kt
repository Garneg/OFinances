package com.garnegsoft.ofinance.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTab(modifier: Modifier = Modifier) {
    Scaffold(
        modifier = modifier,
        topBar = {
            LargeTopAppBar(
                title = { Text("Доброй ночи, пользователь") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },

        ) { scaffoldPadding ->
        Column(
            modifier = Modifier
                .padding(scaffoldPadding)
                .padding(16.dp)
        ) {
            MainScreenItemTitle("Хранилища")
            Spacer(modifier = Modifier.height(16.dp))
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                ContainerListItem(
                    vaultTitle = "\uD83D\uDCB0 Бак с бабками",
                    onClick = {

                    }
                )

                ContainerListItem(
                    vaultTitle = "⚡ Фонд благосостояния",
                    onClick = {

                    }
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            MainScreenItemTitle("Цели")
            Spacer(modifier = Modifier.height(16.dp))
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                ContainerListItem("\uD83D\uDEB2 Велосипед", onClick = {})
                ContainerListItem("\uD83D\uDDA5\uFE0F Комьютер", onClick = {})
            }


        }
    }
}