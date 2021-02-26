package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.pets
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PetDetailScreen(pet: Pet, onBackClick: () -> Unit) {
    Surface(
        color = MaterialTheme.colors.background,
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
                IconButton(onClick = onBackClick) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
            Column(Modifier.padding(horizontal = 32.dp, vertical = 32.dp)) {
                Text(
                    text = pet.name,
                    style = MaterialTheme.typography.h4,
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = "${pet.type} · ${pet.ageYearsFormatted} · ${pet.gender}",
                    style = MaterialTheme.typography.body1,
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = pet.description,
                    style = MaterialTheme.typography.body1,
                )
            }
        }
    }
}

@Preview("Light Theme")
@Composable
private fun PetDetailScreenLightPreview() {
    MyTheme {
        PetDetailScreen(pets[0], onBackClick = {})
    }
}

@Preview("Dark Theme")
@Composable
private fun PetDetailScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        PetDetailScreen(pets[0], onBackClick = {})
    }
}
