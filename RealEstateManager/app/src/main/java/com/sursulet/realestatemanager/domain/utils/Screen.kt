package com.sursulet.realestatemanager.domain.utils

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object DetailScreen: Screen("detail_screen")
    object AddEditScreen: Screen("add_edit_screen")
    object SearchScreen: Screen("search_screen")
    object MapScreen: Screen("map_screen")
    object LoanScreen: Screen("loan_screen")

    fun withArgs(vararg args: Long): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
