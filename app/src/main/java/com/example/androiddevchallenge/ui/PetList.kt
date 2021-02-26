package com.example.androiddevchallenge.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.pets
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PetList(
    pets: List<Pet>,
    onClick: (Pet) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 0.dp, vertical = 8.dp)
    ) {
        itemsIndexed(pets) { index, pet ->
            PetRow(
                pet,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(pet) }
            )
            if (index != pets.lastIndex) {
                Divider(startIndent = 116.dp)
            }
        }
    }
}

@Preview("Light Theme")
@Composable
private fun PetListLightPreview() {
    MyTheme {
        Surface(color = MaterialTheme.colors.background) {
            PetList(pets, onClick = {})
        }
    }
}

@Preview("Dark Theme")
@Composable
private fun PetListDarkPreview() {
    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            PetList(pets, onClick = {})
        }
    }
}
