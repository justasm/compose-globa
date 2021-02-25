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
