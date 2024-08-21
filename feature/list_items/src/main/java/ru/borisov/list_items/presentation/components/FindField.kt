package ru.borisov.list_items.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.borisov.list_items.R

@Composable
fun FindField(
    textInField: TextFieldValue = TextFieldValue("Test text"),
    onChangeText: (TextFieldValue) -> Unit = {},
    onClickClose: () -> Unit = {},
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
        value = textInField,
        onValueChange = { onChangeText(it) },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            errorContainerColor = Color.White,
        ),
        singleLine = true,
        leadingIcon = { IconSearch() },
        trailingIcon = {
            if (textInField.text.isNotEmpty()) {
                IconCLose { onClickClose() }
            }
        },
        label = { Text(stringResource(R.string.text_search_items)) },
    )
}

@Composable
private fun IconCLose(onClickClose: () -> Unit) {
    IconButton(onClick = { onClickClose() }) {
        Icon(
            modifier = Modifier.padding(10.dp),
            imageVector = Icons.Rounded.Close,
            tint = Color.Black,
            contentDescription = stringResource(R.string.text_close)
        )
    }
}

@Composable
private fun IconSearch() {
    Icon(
        modifier = Modifier
            .padding(start = 16.dp, end = 8.dp)
            .padding(vertical = 10.dp),
        imageVector = Icons.Rounded.Search,
        tint = Color.Black,
        contentDescription = stringResource(R.string.text_search)
    )
}

@Composable
@Preview(showBackground = true)
fun FindField_Preview() {
    FindField()
}