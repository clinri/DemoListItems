package ru.borisov.list_items.presentation.components

import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import ru.borisov.list_items.R
import ru.borisov.ui.theme.IconsDialogColor

@Composable
fun TextButtonDismiss(onDismissRequest: () -> Unit) {
    TextButton(onClick = onDismissRequest) {
        Text(
            text = stringResource(R.string.text_cancel),
            color = IconsDialogColor,
        )
    }
}