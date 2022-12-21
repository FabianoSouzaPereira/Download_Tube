package com.fabianospdev.downloadtube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

class Downloads : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { downloadContent() }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    @Preview
    private fun downloadContent() {
        Scaffold(
            topBar = { DownloadTopBar() },
            content = { Downloadcontent("") },
        )
    }

    @Composable
    private fun DownloadTopBar() {
        SmallTopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.title_activity_downloads),
                    color = Color.White,
                    fontSize = 18.sp,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.W500,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = TextUnit.Unspecified,
                    textDecoration = TextDecoration.Underline,
                    textAlign = TextAlign.Center,
                    lineHeight = 35.sp,
                    overflow = TextOverflow.Clip,
                    softWrap = false,
                    maxLines = Int.MAX_VALUE,
                    style = LocalTextStyle.current,
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Blue,
                navigationIconContentColor = Color.White
            ),
            navigationIcon = { IconButton(onClick = { onBackPressed() }) {
                Icon(imageVector = Icons.Default.ArrowBack, "Return")
            } }
        )
    }

    @Composable
    private fun Downloadcontent(name: String?) {
        Text(text = "Conteudo")
    }
}


