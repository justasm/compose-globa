package com.example.androiddevchallenge.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.pets
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun MyApp(systemInDarkTheme: Boolean = isSystemInDarkTheme()) {
    var inDarkTheme by remember(systemInDarkTheme) { mutableStateOf(systemInDarkTheme) }
    val navController = rememberNavController()

    MyTheme(darkTheme = inDarkTheme) {
        NavHost(navController, startDestination = "list") {
            composable("list") {
                PetListScreen(
                    pets = pets,
                    onPetClick = { pet ->
                        navController.navigate("pet/${pet.url}")
                    },
                    inDarkTheme = inDarkTheme,
                    onToggleDarkThemeClick = { inDarkTheme = !inDarkTheme },
                )
            }
            composable("pet/{petUrl}") { backStackEntry ->
                val petUrl = backStackEntry.arguments?.getString("petUrl")
                pets.find { it.url == petUrl }?.let { pet ->
                    PetDetailScreen(
                        pet = pet,
                        onBackClick = { navController.popBackStack() },
                    )
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyApp(systemInDarkTheme = false)
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyApp(systemInDarkTheme = true)
}
