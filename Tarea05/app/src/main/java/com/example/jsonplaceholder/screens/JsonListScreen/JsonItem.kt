package com.example.jsonplaceholder.screens.JsonListScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jsonplaceholder.model.Json

@Composable
fun JsonItem(
    json: Json
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(
                10.dp,
                alignment = Alignment.CenterVertically
            )
        ) {
            Text(text = "UserId: ${json.userId}")
            Spacer(Modifier.padding(3.dp))
            Text(text = "Id: ${json.id}")
            Spacer(Modifier.padding(3.dp))
            Text(text = "Title: ${json.title}")
            Spacer(Modifier.padding(3.dp))
            Text(text = "Body: ${json.body}")
        }
    }
}