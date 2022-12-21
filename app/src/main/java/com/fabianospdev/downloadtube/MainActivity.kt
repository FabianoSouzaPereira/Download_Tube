package com.fabianospdev.downloadtube

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
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


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainContent() }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    private fun MainContent() {
        Scaffold(
            topBar = { MainTopBar() },
            floatingActionButton = { MainFab() },
        ) {}
    }

    @Composable
    private fun MainTopBar(){
        TopAppBar(title = {
            Text(
                text = stringResource(id = R.string.app_name),
                color = androidx.compose.ui.graphics.Color.Blue,
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
        })
    }

    @Composable
    private fun MainFab(){
        val context = LocalContext.current
        FloatingActionButton(onClick = { showDownloadActivity(context) }) {
            Icon(imageVector = Icons.Filled.Add, "add")
        }
    }

    private fun showDownloadActivity(context: Context){
        context.startActivity(Intent(context, Downloads::class.java))
    }

}

