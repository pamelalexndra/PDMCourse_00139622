package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.ColorRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                    Layout()
                }
            }
        }
    }
data class QuadrantData(
    @StringRes val titleRes: Int,
    @StringRes val descRes: Int,
    @ColorRes val colorRes: Int
)
@Composable
fun Layout() {

    val itemsList = listOf(
        QuadrantData(R.string.TitleText, R.string.DescText, R.color.purple_200),
        QuadrantData(R.string.TitleImage, R.string.DescImage, R.color.purple_500),
        QuadrantData(R.string.TitleRow, R.string.DescRow, R.color.purple_700),
        QuadrantData(R.string.TitleColumn, R.string.DescColumn, R.color.teal_200)
    )

    Column(Modifier.fillMaxSize()) {
        itemsList.chunked(2).forEach { rowItems ->
            Row(Modifier.weight(1f)) {
                rowItems.forEach { item ->
                    Quadrant(
                        title = stringResource(id = item.titleRes),
                        description = stringResource(id = item.descRes),
                        backgroundColor = colorResource(id = item.colorRes),
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}

@Composable
fun Quadrant(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        Layout()
    }
}