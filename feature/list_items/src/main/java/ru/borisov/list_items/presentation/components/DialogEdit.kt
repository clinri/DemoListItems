package ru.borisov.list_items.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AddCircleOutline
import androidx.compose.material.icons.rounded.RemoveCircleOutline
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
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
import ru.borisov.ui.VerticalSpacer
import ru.borisov.ui.theme.DialogBackgroundColor
import ru.borisov.ui.theme.IconsDialogColor

@Composable
fun DialogEdit(
    amount: Int = 84,
    onApproveRequest: (Int) -> Unit = {},
    onDismissRequest: () -> Unit = {},
) {
    val amountChanged = remember { mutableIntStateOf(amount) }
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
                        imageVector = Icons.Rounded.Settings,
                        contentDescription = null,
                        tint = IconsDialogColor
                    )
                    VerticalSpacer(8.dp)
                    Text(
                        text = stringResource(R.string.text_amount_items),
                        fontSize = 24.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                        textAlign = TextAlign.Center,
                    )
                    VerticalSpacer(24.dp)
                    Row {
                        Spacer(modifier = Modifier.weight(1f))
                        IconPlus(amountChanged)
                        Text(
                            modifier = Modifier
                                .weight(1f)
                                .align(Alignment.CenterVertically),
                            text = amountChanged.intValue.toString(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight(400),
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                        )
                        IconMinus(amountChanged)
                        Spacer(modifier = Modifier.weight(1f))
                    }
                    VerticalSpacer(24.dp)
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End,
                    ) {
                        TextButtonDismiss(onDismissRequest)
                        TextButtonApproveEdit(onApproveRequest, amountChanged)
                    }
                }
            }
        }
    }
}

@Composable
private fun IconMinus(amountChanged: MutableIntState) {
    IconButton(onClick = { amountChanged.intValue += 1 }) {
        Icon(
            imageVector = Icons.Rounded.AddCircleOutline,
            contentDescription = null,
            tint = IconsDialogColor
        )
    }
}

@Composable
private fun IconPlus(amountChanged: MutableIntState) {
    IconButton(onClick = { if (amountChanged.intValue != 0) amountChanged.intValue -= 1 }) {
        Icon(
            imageVector = Icons.Rounded.RemoveCircleOutline,
            contentDescription = null,
            tint = IconsDialogColor
        )
    }
}

@Composable
private fun TextButtonApproveEdit(
    onApproveRequest: (Int) -> Unit,
    amountChanged: MutableIntState,
) {
    TextButton(onClick = { onApproveRequest(amountChanged.intValue) }) {
        Text(
            text = stringResource(R.string.text_approve),
            color = IconsDialogColor,
        )
    }
}

@Composable
@Preview(showBackground = true)
fun DialogEdit_Preview() {
    DialogEdit {}
}