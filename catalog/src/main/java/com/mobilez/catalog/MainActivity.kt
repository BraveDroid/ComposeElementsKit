package com.mobilez.catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilez.compose.elementskit.R
import com.mobilez.elementskit.theme.ComposePlaygroundTheme
import com.mobilez.elementskit.elements.CircleImageTextRow
import com.mobilez.elementskit.elements.ExpandableCard
import com.mobilez.elementskit.elements.HomeSection
import com.mobilez.elementskit.elements.MediaTextCardCollectionsGrid
import com.mobilez.elementskit.elements.SearchBar
import com.mobilez.elementskit.elements.TwoMenuBottomNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                Scaffold(
                    bottomBar = { TwoMenuBottomNavigation() },
                ) { padding ->
                    HomeScreen(Modifier.padding(padding))
                }
            }
        }
    }
}


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background,
    ) {
        Column {
            SearchBar(Modifier.padding(8.dp))
            ExpandableCard(title = "Android") {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                        "padding theme elit, sed do bouncy. ").repeat(4),
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                        "padding theme elit, sed do bouncy. ").repeat(2),
                )
            }
            Spacer(Modifier.height(16.dp))
            HomeSection(R.string.circle_imageText_Row) {
                CircleImageTextRow()
            }
            Spacer(Modifier.height(16.dp))
            HomeSection(R.string.media_textCard_collections_grid) {
                MediaTextCardCollectionsGrid()
            }
        }
    }
}
