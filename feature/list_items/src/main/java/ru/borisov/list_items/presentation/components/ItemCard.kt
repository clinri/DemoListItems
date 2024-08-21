package ru.borisov.list_items.presentation.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.borisov.list_items.R
import ru.borisov.models.Item
import ru.borisov.ui.HorizontalSpacer
import ru.borisov.ui.VerticalSpacer
import ru.borisov.ui.theme.DeleteButtonColor
import ru.borisov.ui.theme.EditButtonColor
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun ItemCard(
    item: Item = Item(),
    onClickEdit: () -> Unit = {},
    onCLickDelete: () -> Unit = {},
) {
    val focusManager = LocalFocusManager.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .pointerInput(Unit) { detectTapGestures(onTap = { focusManager.clearFocus() }) },
        shape = RoundedCornerShape(6.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Box(modifier = Modifier.padding(all = 8.dp)) {
            Column {
                Row {
                    ItemName(
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically),
                        name = item.name
                    )
                    HorizontalSpacer(8.dp)
                    IconEdit(onClickEdit)
                    IconDelete(onCLickDelete)
                }
                VerticalSpacer(8.dp)
                Chips(item.tags)
                Row {
                    Amount(modifier = Modifier.weight(1f), amount = item.amount)
                    DateAdded(modifier = Modifier.weight(1f), date = item.time)
                }
            }
        }
    }
}

@Composable
private fun DateAdded(
    modifier: Modifier,
    date: Date,
) {
    ItemTitleValue(
        modifier = modifier,
        title = stringResource(R.string.text_date_add),
        value = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(date)
    )
}

@Composable
private fun Amount(
    modifier: Modifier,
    amount: Int,
) {
    ItemTitleValue(
        modifier = modifier,
        title = stringResource(R.string.text_on_warehouse),
        value = when (amount == 0) {
            true -> stringResource(R.string.text_out_of_stock)
            false -> amount.toString()
        }
    )
}

@Composable
private fun ItemName(
    modifier: Modifier,
    name: String,
) {
    Text(
        modifier = modifier,
        text = name,
        fontSize = 24.sp,
    )
}

@Composable
private fun IconEdit(onClickEdit: () -> Unit) {
    IconButton(onClick = onClickEdit) {
        Icon(
            imageVector = Icons.Rounded.Edit,
            contentDescription = stringResource(R.string.text_edit),
            tint = EditButtonColor
        )
    }
}

@Composable
private fun IconDelete(onCLickDelete: () -> Unit) {
    IconButton(onClick = onCLickDelete) {
        Icon(
            imageVector = Icons.Rounded.Delete,
            contentDescription = stringResource(R.string.text_delete),
            tint = DeleteButtonColor
        )
    }
}

@Composable
@OptIn(ExperimentalLayoutApi::class)
private fun Chips(tags: List<String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy((-12).dp),
        modifier = Modifier.padding(4.dp)
    ) {
        tags.forEach {
            FilterChip(
                selected = false,
                onClick = { },
                label = { Text(it) }
            )
        }
    }
}

@Composable
fun ItemTitleValue(
    modifier: Modifier = Modifier,
    title: String = "Заголовок",
    value: String = "3",
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            fontSize = 16.sp,
            fontWeight = FontWeight(500),
            text = title,
        )
        VerticalSpacer(8.dp)
        Text(
            fontSize = 16.sp,
            fontWeight = FontWeight(400),
            text = value
        )
    }
}

@Preview
@Composable
fun ItemCard_Preview() {
    ItemCard()
}
