package br.com.oiti.certiface.sample.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import br.com.oiti.certiface.sample.ui.theme.BrandColors.Companion.PrimaryDark
import br.com.oiti.certiface.sample.ui.theme.BrandColors.Companion.PrimaryPure
import br.com.oiti.certiface.sample.ui.theme.HighlightColors.Companion.HighlightDark
import br.com.oiti.certiface.sample.ui.theme.HighlightColors.Companion.HighlightPure
import br.com.oiti.certiface.sample.ui.theme.NeutralColors.Companion.HighDark
import br.com.oiti.certiface.sample.ui.theme.NeutralColors.Companion.HighPure

private val DarkColorScheme = darkColorScheme(
    primary = HighlightDark,
    secondary = HighDark,
    tertiary = PrimaryDark
)

private val LightColorScheme = lightColorScheme(
    primary = HighlightPure,
    secondary = HighPure,
    tertiary = PrimaryPure

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun CertifacesdksampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}