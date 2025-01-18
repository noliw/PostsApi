package com.nolawiworkineh.countriesapi.presentation.components

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PelotonLoadingSpinner(
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            color = Color.Gray,
            strokeWidth = 4.dp
        )
    }

}


@Preview(showSystemUi = true)
@Composable
private fun PelotonLoadingSpinnerPreview() {
    PelotonLoadingSpinner()
}
