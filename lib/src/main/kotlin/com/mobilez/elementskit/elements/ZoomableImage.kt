package com.mobilez.elementskit.elements

import android.util.Log
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.mobilez.compose.elementskit.R
import com.mobilez.elementskit.theme.ComposePlaygroundTheme
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

data class ZoomDragAmount(
    val zoom: Float,
    val DragAmmount: Float,
)

@Composable
fun ZoomableImage(modifier: Modifier = Modifier) {
    var scale by remember { mutableStateOf(1f) }
    val animatingScale by animateFloatAsState(
        targetValue = scale,
        animationSpec = spring(
            stiffness = Spring.StiffnessLow,
        ),
    )

    var offsetX by remember { mutableStateOf(0f) }
    val animatingOffsetX by animateFloatAsState(
        targetValue = offsetX,
        // animationSpec = tween(
        //     durationMillis = 500,
        //     easing = LinearOutSlowInEasing,
        // ),
    )

    var offsetY by remember { mutableStateOf(0f) }
    val animatingOffsetY by animateFloatAsState(
        targetValue = offsetY,
        // animationSpec = tween(
        //     durationMillis = 500,
        //     easing = LinearOutSlowInEasing,
        // ),
    )

    var isPitchDetected by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val gestureEvents = remember { MutableSharedFlow<ZoomDragAmount>() }

    LaunchedEffect(key1 = isPitchDetected) {
        if (!isPitchDetected) {
            scale = 1f
            offsetX = 0f
            offsetY = 0f
        }
    }
    LaunchedEffect(Unit) {
        gestureEvents
            .distinctUntilChanged()
            .debounce(300L)
            .collect {
                Log.d("ZoomableImage", "Gesture event received")
                if (isPitchDetected) {
                    Log.d("ZoomableImage", "Gesture event received and isPitchDetected is true")
                    isPitchDetected = false
                }
            }
    }
    Image(
        painter = painterResource(id = R.drawable.flower),
        contentDescription = "Your Image",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .zIndex(if (isPitchDetected) Float.MAX_VALUE else 0F)
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectTransformGestures(
                    onGesture = { centroid, pan, zoom, dragAmount ->
                        coroutineScope.launch {
                            gestureEvents.emit(ZoomDragAmount(zoom, dragAmount))

                            Log.d("ZoomableImage", "Centroid: $centroid, Pan: $pan, Zoom: $zoom, DragAmount: $dragAmount")

                            isPitchDetected = true
                            val newScale = (scale * zoom).coerceIn(1f, 3f)
                            val isZooming = newScale > 1f
                            scale = newScale

                            offsetX += dragAmount.plusIf(pan.x) {
                                isZooming
                            }
                            offsetY += dragAmount.plusIf(pan.y) {
                                isZooming
                            }

                            if (zoom.isNearOne() && dragAmount.isNearZero()) {
                                isPitchDetected = false
                                Log.d("ZoomableImage", "Gesture ended")
                            }
                        }
                    },
                )
            }
            .graphicsLayer(
                scaleX = animatingScale,
                scaleY = animatingScale,
                translationX = animatingOffsetX,
                translationY = animatingOffsetY,
            ),
    )
}

private fun Modifier.then(action: () -> Modifier): Modifier = this.then(action())

private fun Float.plusIf(floatToAdd: Float, predicate: () -> Boolean): Float = if (predicate()) {
    this.plus(floatToAdd)
} else {
    this
}

private fun Float.isNearOne(): Boolean =
    // this == 1f
    (this - 1f).absoluteValue < 0.01f

private fun Float.isNearZero(): Boolean = (this).absoluteValue == 0f

@Preview
@Composable
private fun ZoomableImagePrev() {
    ComposePlaygroundTheme {
        Column(Modifier.fillMaxSize()) {
            Text(
                text = "Ceci est la ligne 1.\nCeci est la ligne 2.\nCeci est la ligne 3.",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp),
            )
            ZoomableImage()
            Text(
                text = "Ceci est la ligne 1.\nCeci est la ligne 2.\nCeci est la ligne 3.",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(16.dp),
            )
        }
    }
}
