package com.mobilez.elementskit.elements

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.mobilez.compose.elementskit.R
import com.mobilez.elementskit.theme.ComposePlaygroundTheme

@Composable
fun ZoomableImage() {
    val scale = remember { mutableStateOf(1f) }
    val animatingScale = animateFloatAsState(targetValue = scale.value)

    val offsetX = remember { mutableStateOf(0f) }
    val offsetY = remember { mutableStateOf(0f) }

    Image(
        painter = painterResource(id = R.drawable.rose),
        contentDescription = "Your Image",
        contentScale = ContentScale.Inside,
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTransformGestures { _, _, zoom, _ ->
                    scale.value = (scale.value * zoom).coerceIn(1f, 3f)
                }
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    offsetX.value += dragAmount.x
                    offsetY.value += dragAmount.y
                }
            }
            .graphicsLayer(
                scaleX = animatingScale.value,
                scaleY = animatingScale.value,
                translationX = offsetX.value,
                translationY = offsetY.value,
            ),
    )
}

@Preview
@Composable
private fun ZoomableImagePrev() {
    ComposePlaygroundTheme { ZoomableImage() }
}
