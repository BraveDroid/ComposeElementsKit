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
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobilez.elementskit.ComposePlaygroundTheme
import com.mobilez.elementskit.elements.ExpandableCard
import com.mobilez.elementskit.elements.SearchBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePlaygroundTheme {
                // A surface container using the 'background' color from the theme
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
                    }
                }
            }
        }
    }
}
