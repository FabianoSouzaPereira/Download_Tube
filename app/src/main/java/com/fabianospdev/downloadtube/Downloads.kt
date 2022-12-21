package com.fabianospdev.downloadtube

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        TopAppBar(
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
            navigationIcon = {
                IconButton(onClick = { onBackPressedDispatcher.onBackPressed() }) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack, "Return",
                        tint = Color.White
                    )
                }
            }
        )
    }

    @Composable
    private fun Downloadcontent(name: String?) {
        val linkState = remember { mutableStateOf("") }

        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){

            OutlinedTextField(
                value = linkState.value,
                onValueChange = { linkState.value = it },
                label = { Text(text = "link") },
                placeholder = { Text(text =  stringResource(id = R.string.paste_link)) },
            )
        }
    }
}


