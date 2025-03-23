package com.garnegsoft.ofinance.ui.navigation

import kotlinx.serialization.Serializable


@Serializable
data class MainScreenDestination(
    val tab: Tab = Tab.Home
) {
    enum class Tab {
        Summary,
        Home,
        History
    }
}

