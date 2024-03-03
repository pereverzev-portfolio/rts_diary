package com.example.rts_diary.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rts_diary.ui.theme.RTS_DiaryTheme


@Composable
fun RecommendationScreen(
    navController: NavController
)
{
    ModalNavigationDrawer(
        drawerContent =
        {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
//                                    .background(Color.Blue)
                    .sizeIn(minHeight = 32000.dp) // TODO снять костыль: отображать тулбар снизу экрана
                //(почему-то разными способами, которые работают у других в
                // других ситуациях,но не работает внутри drawer-а)
            )
            {
                Box(modifier = Modifier)
                ToolBarFrame()
                {
                    ToolBarWithContentHome(
                        navController = navController
                    )
                }
            }

        }
    )
    {
        Greeting("Android")
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RTS_DiaryTheme {
        Greeting("Android")
    }
}




