package com.example.rts_diary.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun SettingsScreen()
{
    Column()
    {
        Box(modifier = Modifier.size(100.dp).background(color = Color.Yellow))
        Text("Settings")

    }
}