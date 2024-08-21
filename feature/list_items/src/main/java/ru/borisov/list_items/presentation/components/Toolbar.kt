package ru.borisov.list_items.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.borisov.ui.theme.TopBarBackgroundColor

@Composable
fun Toolbar(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = TopBarBackgroundColor)
            .padding(vertical = 16.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = title,
            textAlign = TextAlign.Center,
            color = Color.Black,
            fontSize = 24.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview
@Composable
fun Toolbar_Preview() {
    Toolbar(title = "Title")
}

@Preview
@Composable
fun Toolbar_LongText_Preview() {
    Toolbar(title = "Title very long text")
}