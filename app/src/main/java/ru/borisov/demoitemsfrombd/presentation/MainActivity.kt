package ru.borisov.demoitemsfrombd.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.toArgb
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import ru.borisov.list_items.presentation.ListItemsScreen
import ru.borisov.ui.theme.DemoItemsFromBdTheme
import ru.borisov.ui.theme.TopBarBackgroundColor

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, true)
        window.statusBarColor = TopBarBackgroundColor.toArgb()
        window.navigationBarColor = TopBarBackgroundColor.toArgb()
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = true
            isAppearanceLightNavigationBars = true
        }
        setContent {
            DemoItemsFromBdTheme {
                ListItemsScreen()
            }
        }
    }
}