package com.mobilez.elementskit.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobilez.compose.elementskit.R
import com.mobilez.elementskit.theme.ComposePlaygroundTheme

@Composable
fun TwoMenuBottomNavigation(
    modifier: Modifier = Modifier,
) {
    var isHomeSelected by remember { mutableStateOf(true) }
    var isProfileSelected by remember { mutableStateOf(false) }
    NavigationBar(
//        containerColor = md_theme_light_error,
        contentColor = Color.Black,
        modifier = modifier,
    ) {
        NavigationBarItem(
//            colors = NavigationBarItemDefaults.colors(
//                selectedIconColor = Color(0xFFE91E63),
//                selectedTextColor = Color(0xFFFFEB3B),
//                indicatorColor = Color(0xFF9C27B0),
//                unselectedIconColor = Color(0xFF03A9F4),
//                unselectedTextColor = Color(0xFF00BCD4),
//            ),
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = isHomeSelected,
            onClick = {
                isHomeSelected = !isHomeSelected
                isProfileSelected = !isProfileSelected
            },
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null,
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = isProfileSelected,
            onClick = {
                isProfileSelected = !isProfileSelected
                isHomeSelected = !isHomeSelected
            },
        )
    }
}

@Preview
@Composable
private fun DemoBottomNavigationPrev() {
    ComposePlaygroundTheme { TwoMenuBottomNavigation(Modifier.padding(top = 24.dp)) }
}
