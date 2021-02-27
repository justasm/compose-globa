package com.example.androiddevchallenge.ui

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.data.pets
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.navigationBarsHeight

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

        // Navigation bar protection.
        // Dynamic instead of android:navigationBarColor in the theme to support dynamic light/dark
        // theme switching.
        // On Q and above, the system automatically enforces contrast.
        // https://medium.com/androiddevelopers/gesture-navigation-going-edge-to-edge-812f62e4e83e
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            Box(Modifier.fillMaxSize()) {
                Spacer(
                    Modifier
                        .background(MaterialTheme.colors.onBackground.copy(alpha = 0.3f))
                        .navigationBarsHeight()
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                )
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
