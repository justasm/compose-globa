package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.pets
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PetRow(
    pet: Pet,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
            .padding(vertical = 16.dp)
            .padding(end = 16.dp)
    ) {
        Image(
            painter = painterResource(pet.resource),
            contentScale = ContentScale.Crop,
            contentDescription = pet.name,
            modifier = Modifier
                .size(100.dp, 56.dp)
        )

        Column {
            Text(
                text = pet.name,
                style = MaterialTheme.typography.body1,
            )
            Text(
                text = "${pet.type} ${pet.ageYearsFormatted}",
                style = MaterialTheme.typography.body1,
            )
        }
    }
}

@Preview("Light Theme")
@Composable
private fun PetRowLightPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            PetRow(pets[0])
        }
    }
}

@Preview("Dark Theme")
@Composable
private fun PetRowDarkPreview() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            PetRow(pets[0])
        }
    }
}

private val Pet.ageYearsFormatted: String
    get() {
        val start = ageYears.first
        val end = ageYears.last
        return if (start == end) {
            "$start years"
        } else {
            "$start-$end years"
        }
    }
