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

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.pets
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.toPaddingValues

@Composable
fun PetListScreen(
    pets: List<Pet>,
    onPetClick: (Pet) -> Unit,
    inDarkTheme: Boolean,
    onToggleDarkThemeClick: () -> Unit,
) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(
            contentPadding = PaddingValues(bottom = 16.dp) +
                LocalWindowInsets.current.systemBars.toPaddingValues(),
        ) {
            item {
                PetListHeader(inDarkTheme, onToggleDarkThemeClick)
            }

            items(pets.chunked(2)) { pets ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .padding(top = 8.dp)
                ) {
                    pets.forEach { pet ->
                        PetCard(
                            pet,
                            modifier = Modifier
                                .weight(1f)
                                .clickable { onPetClick(pet) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun PetListHeader(
    inDarkTheme: Boolean,
    onToggleDarkThemeClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground),
            modifier = Modifier
                .width(256.dp)
                .padding(top = 32.dp)
        )
        Spacer(Modifier.weight(1f))
        IconButton(
            onClick = onToggleDarkThemeClick,
            modifier = Modifier.align(Alignment.Top)
        ) {
            Icon(
                imageVector = if (inDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                contentDescription = "Toggle dark mode"
            )
        }
    }
}

private operator fun PaddingValues.plus(other: PaddingValues): PaddingValues {
    return object : PaddingValues {
        override fun calculateLeftPadding(layoutDirection: LayoutDirection) =
            this@plus.calculateLeftPadding(layoutDirection) +
                other.calculateLeftPadding(layoutDirection)

        override fun calculateTopPadding(): Dp =
            this@plus.calculateTopPadding() + other.calculateTopPadding()

        override fun calculateRightPadding(layoutDirection: LayoutDirection) =
            this@plus.calculateRightPadding(layoutDirection) +
                other.calculateRightPadding(layoutDirection)

        override fun calculateBottomPadding() =
            this@plus.calculateBottomPadding() + other.calculateBottomPadding()
    }
}

@Preview("Light Theme")
@Composable
private fun PetDetailScreenLightPreview() {
    ProvideWindowInsets {
        MyTheme {
            PetListScreen(
                pets = pets,
                onPetClick = {},
                inDarkTheme = false,
                onToggleDarkThemeClick = {},
            )
        }
    }
}

@Preview("Dark Theme")
@Composable
private fun PetDetailScreenDarkPreview() {
    ProvideWindowInsets {
        MyTheme(darkTheme = true) {
            PetListScreen(
                pets = pets,
                onPetClick = {},
                inDarkTheme = true,
                onToggleDarkThemeClick = {},
            )
        }
    }
}
