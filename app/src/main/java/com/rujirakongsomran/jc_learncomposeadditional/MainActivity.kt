package com.rujirakongsomran.jc_learncomposeadditional

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        pageCount = 10
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


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JC_LearnComposeAdditionalTheme {
        CreateHorizontalPager()
    }
}