package br.com.oiti.certiface.sample.ui.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.unit.dp
import kotlin.let

@Composable
fun LoadingDialog(
    isLoading: Boolean,
    background: Int? = null,
    circularProgressIndicatorColor: Int? = null,
    loadingScaleSize: Int? = null,
    loadingProgressIndicatorWidth: Int? = null,
    content: @Composable () -> Unit
) {
    val interceptBackPressed = remember { mutableStateOf(false) }

    BackHandler(enabled = isLoading && interceptBackPressed.value) {}

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        content()
        if (isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        background?.let { Color(it) } ?: Color.Transparent.copy(alpha = 0.5f)
                    ),
                contentAlignment = Alignment.Center
            ) {
                interceptBackPressed.value = true

                CircularProgressIndicator(
                    modifier = Modifier.size((loadingScaleSize ?: 50).dp),
                    strokeWidth = (loadingProgressIndicatorWidth ?: 5).dp,
                    color = Color(circularProgressIndicatorColor ?: Color.Green.toArgb())
                )
            }
        } else {
            interceptBackPressed.value = false
        }
    }
}