/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import dev.chrisbanes.accompanist.insets.statusBarsHeight

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

        // System bar protection.
        // Dynamic instead of android:statusBarColor / android:navigationBarColor in the theme to
        // support dynamic light/dark theme switching.
        // On Q and above, the system automatically enforces contrast.
        // https://medium.com/androiddevelopers/gesture-navigation-going-edge-to-edge-812f62e4e83e
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            Box(Modifier.fillMaxSize()) {
                Spacer(
                    Modifier
                        .background(MaterialTheme.colors.onBackground.copy(alpha = 0.3f))
                        .statusBarsHeight()
                        .fillMaxWidth()
                )
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
