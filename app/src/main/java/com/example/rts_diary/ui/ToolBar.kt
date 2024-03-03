package com.example.rts_diary.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rts_diary.R



@Composable
fun CustomToolBarButton(
    buttonHorizontalPadding: Dp = 4.dp,
    buttonMinHeight: Dp = 52.dp,
    buttonMinWidth: Dp = 48.dp,
    buttonVerticalPadding: Dp = 4.dp,
    contentDescription: String? = "",
    iconHeight: Dp = 40.dp,
    iconWidth: Dp = 40.dp,
    imageVector: ImageVector = Icons.Rounded.Warning,
    onClick: ()-> Unit = {},
    painter: Painter? = null,
)
{
    FilledTonalButton( // settings
        onClick = onClick,
        modifier = Modifier
            .wrapContentWidth()
            .defaultMinSize(minWidth = buttonMinWidth, minHeight = buttonMinHeight),
        contentPadding = PaddingValues.Absolute(
            top = buttonHorizontalPadding,
            bottom = buttonHorizontalPadding,
            left = buttonVerticalPadding,
            right = buttonVerticalPadding
        ),
        shape = RoundedCornerShape(20),
    )
    {
        if (painter==null)
            Icon(
                imageVector = imageVector,
                contentDescription = contentDescription,
                modifier = Modifier
                    .size(iconWidth, iconHeight))
        else
            Icon(
                painter = painter,
                contentDescription = contentDescription,
                modifier = Modifier
                    .size(iconWidth, iconHeight))
    }
}

@Preview
@Composable
fun CustomButtonPreview()
{
    CustomToolBarButton()
}

@Composable
fun ToolBarFrame(
    content: @Composable RowScope.() -> Unit
)
{
    Card(
        colors = CardDefaults.cardColors(Color.Yellow),
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
    )
    {
        Card(
            colors = CardDefaults.cardColors(Color.Transparent),
            modifier = Modifier.padding(10.dp)
        )
        {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )
        }
    }
}

@Composable
fun ToolBarWithContentHome(
    navController: NavController,
    buttonMinWidth: Dp = 48.dp,
    buttonMinHeight: Dp = 52.dp,
    buttonHorizontalPadding: Dp = 4.dp,
    buttonVerticalPadding: Dp = 4.dp,
    boxWidth: Dp = 4.dp,
    )
{
    ToolBarFrame()
    {
        Text(
            text = stringResource(R.string.toolbar_title),
            fontSize = 6.em,
            fontFamily = FontFamily.SansSerif
        )
        Box(modifier = Modifier.width(boxWidth*2))
        // Go to settings screen
        CustomToolBarButton(
            onClick = {navController.navigate("SettingsScreen")},
            buttonMinWidth = buttonMinWidth,
            buttonMinHeight = buttonMinHeight,
            buttonHorizontalPadding = buttonHorizontalPadding,
            buttonVerticalPadding = buttonVerticalPadding,
            imageVector = Icons.Rounded.Settings,
            contentDescription = stringResource(id = R.string.button_text_settings),
        )
        Box(modifier = Modifier.width(boxWidth))
        // Go to list screen with editing disabled
        CustomToolBarButton(
            onClick = {},
            buttonMinWidth = buttonMinWidth,
            buttonMinHeight = buttonMinHeight,
            buttonHorizontalPadding = buttonHorizontalPadding,
            buttonVerticalPadding = buttonVerticalPadding,
            painter = painterResource(id = R.drawable.icon_watch_only),
            contentDescription = stringResource(R.string.all_tasks_watch_only),
        )
        Box(modifier = Modifier.width(boxWidth))
        // Go to adding a task
        CustomToolBarButton(
            onClick = {},
            buttonMinWidth = buttonMinWidth,
            buttonMinHeight = buttonMinHeight,
            buttonHorizontalPadding = buttonHorizontalPadding,
            buttonVerticalPadding = buttonVerticalPadding,
            imageVector = Icons.Rounded.Add,
            contentDescription = stringResource(R.string.add_new_task_button),
            iconWidth = 44.dp,
            iconHeight = 44.dp
        )
        Box(modifier = Modifier.width(boxWidth))
        // Go to list screen with editing enabled
        CustomToolBarButton(
            onClick = {},
            buttonMinWidth = buttonMinWidth,
            buttonMinHeight = buttonMinHeight,
            buttonHorizontalPadding = buttonHorizontalPadding,
            buttonVerticalPadding = buttonVerticalPadding,
            painter = painterResource(id = R.drawable.icon_range_tasks),
            contentDescription = stringResource(R.string.all_tasks_watch_only),
        )
    }
}

@Composable
fun ToolBarWithContentList(
    canEdit: Boolean,
    navController: NavController,
    buttonMinWidth: Dp = 48.dp,
    buttonMinHeight: Dp = 52.dp,
    buttonHorizontalPadding: Dp = 4.dp,
    buttonVerticalPadding: Dp = 4.dp,
    boxWidth: Dp = 4.dp,
    )
{
    ToolBarFrame()
    {
        Text(
            text = stringResource(R.string.toolbar_title),
            fontSize = 6.em,
            fontFamily = FontFamily.SansSerif
        )
        Box(modifier = Modifier.width(boxWidth*2))
        // Go to settings screen
        CustomToolBarButton(
            onClick = {navController.navigate("SettingsScreen")},
            buttonMinWidth = buttonMinWidth,
            buttonMinHeight = buttonMinHeight,
            buttonHorizontalPadding = buttonHorizontalPadding,
            buttonVerticalPadding = buttonVerticalPadding,
            imageVector = Icons.Rounded.Settings,
            contentDescription = stringResource(id = R.string.button_text_settings),
        )
        Box(modifier = Modifier.width(boxWidth))
        // Create a new task
        CustomToolBarButton(
            onClick = {},
            buttonMinWidth = buttonMinWidth,
            buttonMinHeight = buttonMinHeight,
            buttonHorizontalPadding = buttonHorizontalPadding,
            buttonVerticalPadding = buttonVerticalPadding,
            imageVector = Icons.Rounded.Add,
            contentDescription = stringResource(R.string.add_new_task_button),
            iconWidth = 44.dp,
            iconHeight = 44.dp
        )
        Box(modifier = Modifier.width(boxWidth))
        // TODO implement view-model
        // Toggle "editable" state
        if (canEdit)
        {
            CustomToolBarButton(
                onClick = {},
                buttonMinWidth = buttonMinWidth,
                buttonMinHeight = buttonMinHeight,
                buttonHorizontalPadding = buttonHorizontalPadding,
                buttonVerticalPadding = buttonVerticalPadding,
                painter = painterResource(id = R.drawable.icon_watch_only),
                contentDescription = stringResource(R.string.all_tasks_watch_only),
            )
        }
        else
        {
            CustomToolBarButton(
                onClick = {},
                buttonMinWidth = buttonMinWidth,
                buttonMinHeight = buttonMinHeight,
                buttonHorizontalPadding = buttonHorizontalPadding,
                buttonVerticalPadding = buttonVerticalPadding,
                painter = painterResource(id = R.drawable.icon_range_tasks),
                contentDescription = stringResource(R.string.all_tasks_watch_only),
            )
        }

    }
}




@Preview
@Composable
fun ToolBarListEditablePreview()
{
    ToolBarWithContentList(
        canEdit = true,
        navController = rememberNavController()
    )
}
@Preview
@Composable
fun ToolBarListNotEditablePreview()
{
    ToolBarWithContentList(
        canEdit = false,
        navController = rememberNavController()
    )
}

@Preview
@Composable
fun ToolBarPreview()
{
    ToolBarWithContentHome(rememberNavController())
}
