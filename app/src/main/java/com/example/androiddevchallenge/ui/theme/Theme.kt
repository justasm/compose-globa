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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Transition
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private object ColorPalette {
    val primary = green dark purple200
    val primaryVariant = Color(0xFF4B8E78) dark purple700
    val secondary = red
    val secondaryVariant = secondary
    val background = Color.White dark Color.Black
    val surface = beige dark grey900
    val error = Color(0xFFB00020) dark Color(0xFFCF6679)
    val onPrimary = Color.White dark Color.Black
    val onSecondary = Color.Black dark Color.Black
    val onBackground = brown dark Color.White
    val onSurface = Color.Black dark Color.White
    val onError = Color.White dark Color.Black
}

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val transition = updateTransition(darkTheme)

    val colors = Colors(
        primary = transition.animateColor(ColorPalette.primary).value,
        primaryVariant = transition.animateColor(ColorPalette.primaryVariant).value,
        secondary = transition.animateColor(ColorPalette.secondary).value,
        secondaryVariant = transition.animateColor(ColorPalette.secondaryVariant).value,
        background = transition.animateColor(ColorPalette.background).value,
        surface = transition.animateColor(ColorPalette.surface).value,
        error = transition.animateColor(ColorPalette.error).value,
        onPrimary = transition.animateColor(ColorPalette.onPrimary).value,
        onSecondary = transition.animateColor(ColorPalette.onSecondary).value,
        onBackground = transition.animateColor(ColorPalette.onBackground).value,
        onSurface = transition.animateColor(ColorPalette.onSurface).value,
        onError = transition.animateColor(ColorPalette.onError).value,
        isLight = !darkTheme,
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}

private data class LightDarkColor(val light: Color, val dark: Color)

private infix fun Color.dark(dark: Color) = LightDarkColor(light = this, dark = dark)

@Composable
private fun Transition<Boolean>.animateColor(color: LightDarkColor) =
    animateColor { dark -> if (dark) color.dark else color.light }

@Composable
private fun Transition<Boolean>.animateColor(color: Color) = animateColor { color }
