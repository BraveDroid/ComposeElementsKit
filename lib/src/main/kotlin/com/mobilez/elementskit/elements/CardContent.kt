package com.mobilez.elementskit.elements

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import com.mobilez.compose.elementskit.R.string

@Composable
fun ExpandableCard(
    title: String,
    modifier: Modifier = Modifier,
    isExpended: Boolean = false,
    content: @Composable () -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary),
        modifier = modifier.padding(vertical = 4.dp, horizontal = 8.dp),
    ) {
        var expanded by remember { mutableStateOf(isExpended) }
        Column(
            modifier = Modifier
                .padding(12.dp)
                .animateContentSize(
//                    animationSpec = spring(
//                        dampingRatio = Spring.DampingRatioMediumBouncy,
//                        stiffness = Spring.StiffnessLow,
//                    ),
                    animationSpec = tween(
                        durationMillis = 300,
                    ),
                ),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 12.dp),
                ) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.headlineMedium.copy(
                            fontWeight = FontWeight.ExtraBold,
                        ),
                    )
                }
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Filled.ExpandLess else Filled.ExpandMore,
                        contentDescription = if (expanded) {
                            stringResource(string.show_less)
                        } else {
                            stringResource(string.show_more)
                        },
                    )
                }
            }
            if (expanded) content()
        }
    }
}

@Preview(
    name = "tablet",
    device = "spec:width=1280dp,height=800dp,dpi=480",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
)
@Preview(
    name = "Phone",
    device = "spec:width=411dp,height=891dp",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    wallpaper = Wallpapers.RED_DOMINATED_EXAMPLE,
)
@Composable
private fun ExpandableCardPrev() {
    ExpandableCard(
        title = "Card Title",
        isExpended = true,
        content = {
            Text(
                text = ("Composem ipsum color sit lazy, " +
                    "padding theme elit, sed do bouncy. ").repeat(4),
            )
        },
    )
}
