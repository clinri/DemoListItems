package ru.borisov.list_items.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import ru.borisov.list_items.R
import ru.borisov.models.Item
import ru.borisov.ui.VerticalSpacer
import ru.borisov.ui.theme.DialogBackgroundColor
import ru.borisov.ui.theme.IconsDialogColor

@Composable
fun DialogDelete(
    item: Item = Item(),
    onApproveRequest: (Item) -> Unit = {},
    onDismissRequest: () -> Unit = {},
) {
    val amountChanged = remember { mutableStateOf(item) }
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = Modifier
                .wrapContentHeight()
                .height(280.dp),
            colors = CardDefaults.cardColors(containerColor = DialogBackgroundColor),
            shape = RoundedCornerShape(28.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 8.dp, horizontal = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Warning,
                        contentDescription = null,
                        tint = IconsDialogColor
                    )
                    VerticalSpacer(8.dp)
                    Text(
                        text = stringResource(R.string.text_delete_item),
                        fontSize = 24.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )
                    VerticalSpacer(24.dp)
                    Text(text = stringResource(R.string.text_confirm_delete))
                    VerticalSpacer(24.dp)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                    ) {
                        TextButtonDismiss(onDismissRequest)
                        TextButtonApproveDelete(onApproveRequest, amountChanged)
                    }
                }
            }
        }
    }
}

@Composable
private fun TextButtonApproveDelete(
    onApproveRequest: (Item) -> Unit,
    amountChanged: MutableState<Item>,
) {
    TextButton(onClick = { onApproveRequest(amountChanged.value) }) {
        Text(
            text = stringResource(R.string.text_approve),
            color = IconsDialogColor,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun DialogDelete_Preview() {
    DialogDelete {}
}