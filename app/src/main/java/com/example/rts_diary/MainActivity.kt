package com.example.rts_diary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rts_diary.ui.RecommendationScreen
import com.example.rts_diary.ui.SettingsScreen
import com.example.rts_diary.ui.theme.RTS_DiaryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RTS_DiaryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "RecommendationScreen")
                    {
                        composable(route = "RecommendationScreen")
                        {
                            RecommendationScreen(navController = navController)
                        }
                        composable(route = "ListScreen")
                        {

                        }
                        composable(route = "SettingsScreen")
                        {
                            SettingsScreen()
                        }
                    }


                }
            }
        }
    }
}
