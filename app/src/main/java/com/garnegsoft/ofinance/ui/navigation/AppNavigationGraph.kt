package com.garnegsoft.ofinance.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.garnegsoft.ofinance.ui.screens.main.MainScreen


@Composable
fun AppNavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = MainScreenDestination()
    ) {
        composable<MainScreenDestination> { navBackStackEntry ->
            MainScreen()
        }
    }
}
