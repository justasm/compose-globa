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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PetDetailCard(
    value: String,
    description: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary,
) {
    val icon = rememberVectorPainter(Icons.Default.Pets)
    val iconSize = with(LocalDensity.current) { 64.dp.toPx() }.let { Size(it, it) }
    Surface(
        color = color,
        shape = MaterialTheme.shapes.small,
        modifier = modifier,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .drawBehind {
                    withTransform({
                        translate(
                            left = size.width - iconSize.width * 3f / 4,
                            top = size.height - iconSize.height * 3f / 8,
                        )
                        rotate(
                            degrees = -20f,
                            pivot = Offset(iconSize.width / 2, iconSize.height / 2),
                        )
                    }) {
                        with(icon) { draw(iconSize, alpha = 0.1f) }
                    }
                }
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.SemiBold),
                maxLines = 1,
            )
            Text(
                text = description,
                style = MaterialTheme.typography.body1,
                maxLines = 1,
            )
        }
    }
}

@Preview("Standard")
@Composable
private fun PetDetailCardPreview() {
    MyTheme {
        PetDetailCard("Female", "Sex")
    }
}

@Preview("Wide")
@Composable
private fun PetDetailCardWidePreview() {
    MyTheme {
        PetDetailCard("An interesting detail", "Fact")
    }
}
