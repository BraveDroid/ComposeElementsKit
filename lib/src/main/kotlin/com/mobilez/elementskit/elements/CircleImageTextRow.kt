package com.mobilez.elementskit.elements

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobilez.compose.elementskit.R
import com.mobilez.compose.elementskit.R.string
import com.mobilez.elementskit.theme.ComposePlaygroundTheme
import java.util.Locale

private val circleImageTexData = listOf(
    R.drawable.demo to R.string.image_text,
    R.drawable.demo to R.string.image_text,
    R.drawable.demo to R.string.image_text,
    R.drawable.demo to R.string.image_text,
    R.drawable.demo to R.string.image_text,
    R.drawable.demo to R.string.image_text,
).map { DrawableStringPair(it.first, it.second) }

@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier) {
        Text(
            text = stringResource(title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp),
        )
        content()
    }
}

@Composable
fun CircleImageTextRow(
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier,
    ) {
        items(circleImageTexData) { item ->
            CircleImageText(item.drawable, item.text)
        }
    }
}

@Preview
@Composable
private fun CircleImageTextRowPrev() {
    ComposePlaygroundTheme {
        HomeSection(string.image_text) {
            CircleImageTextRow()
        }
    }
}
