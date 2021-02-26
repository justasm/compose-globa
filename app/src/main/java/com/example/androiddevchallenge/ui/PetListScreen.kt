package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.pets
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PetListScreen(
    pets: List<Pet>,
    onPetClick: (Pet) -> Unit,
    inDarkTheme: Boolean,
    onToggleDarkThemeClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
            ) {
                Text(
                    text = "Tautmilės Globa",
                    style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(1f)
                )
                IconButton(
                    onClick = onToggleDarkThemeClick,
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    Icon(
                        imageVector = if (inDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                        contentDescription = "Toggle dark mode"
                    )
                }
            }
        }
    ) {
        PetList(pets, onClick = onPetClick)
    }
}

@Preview("Light Theme")
@Composable
private fun PetDetailScreenLightPreview() {
    MyTheme {
        PetListScreen(
            pets = pets,
            onPetClick = {},
            inDarkTheme = false,
            onToggleDarkThemeClick = {},
        )
    }
}

@Preview("Dark Theme")
@Composable
private fun PetDetailScreenDarkPreview() {
    MyTheme(darkTheme = true) {
        PetListScreen(
            pets = pets,
            onPetClick = {},
            inDarkTheme = true,
            onToggleDarkThemeClick = {},
        )
    }
}
