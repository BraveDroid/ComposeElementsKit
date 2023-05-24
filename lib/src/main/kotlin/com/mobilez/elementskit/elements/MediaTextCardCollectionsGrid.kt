package com.mobilez.elementskit.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobilez.compose.elementskit.R
import com.mobilez.compose.elementskit.R.string
import com.mobilez.elementskit.theme.ComposePlaygroundTheme

val MediaTextCardCollectionsData = listOf(
    R.drawable.demo to R.string.image_text,
    R.drawable.demo to R.string.image_text,
    R.drawable.demo to R.string.image_text,
    R.drawable.demo to R.string.image_text,
    R.drawable.demo to R.string.image_text,
    R.drawable.demo to R.string.image_text,
).map { DrawableStringPair(it.first, it.second) }

@Composable
fun MediaTextCardCollectionsGrid(
    modifier: Modifier = Modifier,
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.height(120.dp),
    ) {
        items(MediaTextCardCollectionsData) { item ->
            MediaTextCard(item.drawable, item.text, Modifier.height(56.dp))
        }
    }
}

@Preview
@Composable
private fun MediaTextCardCollectionsGridPrev() {
    ComposePlaygroundTheme {
        HomeSection(title = string.image_text) {
            MediaTextCardCollectionsGrid()
        }
    }
}
