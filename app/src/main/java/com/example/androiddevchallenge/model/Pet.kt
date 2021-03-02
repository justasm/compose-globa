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
package com.example.androiddevchallenge.model

import androidx.annotation.DrawableRes

data class Pet(
    val name: String,
    @DrawableRes val resource: Int,
    val type: PetType,
    val gender: Gender,
    val ageYears: IntRange,
    val description: String,
    val url: String,
)

enum class PetType {
    Cat,
    Dog,
}

enum class Gender {
    Female,
    Male,
}

fun Pet.formatAgeYearsRange(): String {
    val start = ageYears.first
    val end = ageYears.last
    return if (start == end) {
        "$start"
    } else {
        // u2013 - en dash
        "$start\u2013$end"
    }
}

fun Pet.formatAgeYearsLabel(): String {
    val start = ageYears.first
    val end = ageYears.last
    return if (start == 1 && end == 1) "year" else "years"
}
