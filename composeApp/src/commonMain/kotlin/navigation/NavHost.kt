package navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import navigation.Route.Home
import navigation.Route.Threads
import screen.HomeScreen
import screen.ThreadsScreen

@Composable
fun NavHost(navHostController: NavHostController = rememberNavController()) =
    NavHost(startDestination = Home, navController = navHostController) {
        composable<Home> {
            HomeScreen { boardName ->
                navHostController.navigate(Threads(boardName))
            }
        }
        composable<Threads> { backStackEntry ->
            val threads = backStackEntry.toRoute<Threads>()
            ThreadsScreen(threads.board)
        }

    }