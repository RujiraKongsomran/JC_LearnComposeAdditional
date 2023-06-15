package com.rujirakongsomran.jc_learncomposeadditional

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rujirakongsomran.jc_learncomposeadditional.ui.theme.JC_LearnComposeAdditionalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JC_LearnComposeAdditionalTheme {
                CreateHorizontalPager()
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CreateHorizontalPager() {

    HorizontalPager(
        pageCount = 10,
        contentPadding = PaddingValues(start = 64.dp),
    ) { page ->
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .size(140.dp)
                .padding(20.dp)
        ) {
            Text(
                text = "Page: $page",
                modifier = Modifier.padding(12.dp)
            )
        }
    }
}

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Filters() {
    val filters = listOf(
        "Washer/Dryer", "Ramp access", "Garden", "Cats OK",
        "Dogs OK", "Smoke-free"
    )

    FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        filters.forEach { title ->
            var selected by remember { mutableStateOf(false) }
            val leadingIcon: @Composable () -> Unit = {
                Icon(Icons.Default.Check, null)
            }
            FilterChip(
                selected = selected,
                onClick = { selected = !selected },
                label = { Text(text = title) },
                leadingIcon = if (selected) leadingIcon else null
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JC_LearnComposeAdditionalTheme {
        Filters()
    }
}