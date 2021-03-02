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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.pets
import com.example.androiddevchallenge.model.Sex
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.model.formatAgeYearsLabel
import com.example.androiddevchallenge.model.formatAgeYearsRange
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PetCard(
    pet: Pet,
    modifier: Modifier = Modifier,
) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = modifier,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .padding(bottom = 8.dp)
                .width(152.dp)
        ) {
            Image(
                painter = painterResource(pet.resource),
                contentScale = ContentScale.Crop,
                contentDescription = pet.name,
                modifier = Modifier.aspectRatio(1f)
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = pet.name,
                style = MaterialTheme.typography.h6,
            )
            PetDetailSnippet(pet)
        }
    }
}

@Composable
private fun PetDetailSnippet(pet: Pet) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Icon(
            when (pet.sex) {
                Sex.Female -> Icons.Default.Female
                Sex.Male -> Icons.Default.Male
            },
            contentDescription = null, modifier = Modifier.size(16.dp)
        )
        Text(
            text = "${pet.type} · ${pet.formatAgeYears()}",
            style = MaterialTheme.typography.body1,
        )
    }
}

@Preview("Light Theme")
@Composable
private fun PetRowLightPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            PetCard(pets[0])
        }
    }
}

@Preview("Dark Theme")
@Composable
private fun PetRowDarkPreview() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            PetCard(pets[0])
        }
    }
}

private fun Pet.formatAgeYears(): String {
    return "${formatAgeYearsRange()} ${formatAgeYearsLabel()}"
}
