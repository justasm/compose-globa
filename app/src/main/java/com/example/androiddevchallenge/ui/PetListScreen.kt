package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.contentColorFor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.pets
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.chrisbanes.accompanist.insets.statusBarsPadding
import dev.chrisbanes.accompanist.insets.toPaddingValues

@Composable
fun PetListScreen(
    pets: List<Pet>,
    onPetClick: (Pet) -> Unit,
    inDarkTheme: Boolean,
    onToggleDarkThemeClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            InsetAwareTopAppBar(
                contentPadding = PaddingValues(horizontal = 16.dp),
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
    ) { innerPadding ->
        PetList(
            pets = pets,
            contentPadding = innerPadding + LocalWindowInsets.current.systemBars.toPaddingValues(top = false),
            onClick = onPetClick
        )
    }
}

@Composable
private fun InsetAwareTopAppBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    contentPadding: PaddingValues,
    elevation: Dp = 4.dp,
    content: @Composable RowScope.() -> Unit,
) {
    Surface(
        color = backgroundColor,
        elevation = elevation,
        modifier = modifier
    ) {
        TopAppBar(
            backgroundColor = Color.Transparent,
            contentColor = contentColor,
            elevation = 0.dp,
            contentPadding = contentPadding,
            modifier = Modifier
                .statusBarsPadding()
                .navigationBarsPadding(bottom = false),
            content = content,
        )
    }
}

private fun PaddingValues(horizontal: Dp = 0.dp, vertical: Dp = 0.dp): PaddingValues =
    PaddingValues(horizontal, vertical)

private operator fun PaddingValues.plus(other: PaddingValues): PaddingValues {
    return object : PaddingValues {
        override fun calculateLeftPadding(layoutDirection: LayoutDirection) =
            this@plus.calculateLeftPadding(layoutDirection) +
                other.calculateLeftPadding(layoutDirection)

        override fun calculateTopPadding(): Dp =
            this@plus.calculateTopPadding() + other.calculateTopPadding()

        override fun calculateRightPadding(layoutDirection: LayoutDirection) =
            this@plus.calculateRightPadding(layoutDirection) +
                other.calculateRightPadding(layoutDirection)

        override fun calculateBottomPadding() =
            this@plus.calculateBottomPadding() + other.calculateBottomPadding()
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
