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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.pets
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.model.formatAgeYearsLabel
import com.example.androiddevchallenge.model.formatAgeYearsRange
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import java.util.Locale

@Composable
fun PetDetailScreen(pet: Pet, onBackClick: () -> Unit) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        Column {
            Box {
                Image(
                    painter = painterResource(pet.resource),
                    contentScale = ContentScale.Crop,
                    contentDescription = pet.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(3 / 2f)
                )
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.statusBarsPadding()
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
            Column(
                Modifier
                    .padding(horizontal = 32.dp, vertical = 32.dp)
                    .navigationBarsPadding()
            ) {
                Text(
                    text = pet.name,
                    style = MaterialTheme.typography.h4,
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Icons.Default.Place,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        text = "Vilnius, Lithuania",
                        style = MaterialTheme.typography.caption,
                    )
                }
                Spacer(Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    PetDetailCard(
                        value = pet.sex.toString(),
                        description = "Sex",
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    PetDetailCard(
                        value = pet.type.toString(),
                        description = "Animal",
                        modifier = Modifier.weight(1f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    PetDetailCard(
                        value = pet.formatAgeYearsRange(),
                        description = pet.formatAgeYearsLabel().capitalize(Locale.US),
                        modifier = Modifier.weight(1f)
                    )
                }
                Spacer(Modifier.height(16.dp))
                Text(
                    text = pet.description,
                    style = MaterialTheme.typography.body1,
                )
                Spacer(Modifier.height(16.dp))
                Button(
                    onClick = { },
                    contentPadding = PaddingValues(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Get in touch")
                }
            }
        }
    }
}

@Preview("Light Theme")
@Composable
private fun PetDetailScreenLightPreview() {
    ProvideWindowInsets {
        MyTheme {
            PetDetailScreen(pets[0], onBackClick = {})
        }
    }
}

@Preview("Dark Theme")
@Composable
private fun PetDetailScreenDarkPreview() {
    ProvideWindowInsets {
        MyTheme(darkTheme = true) {
            PetDetailScreen(pets[0], onBackClick = {})
        }
    }
}
