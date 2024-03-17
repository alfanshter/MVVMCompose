package com.example.mvvmcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mvvmcompose.api.TweetApi
import com.example.mvvmcompose.screen.CategoryScreen
import com.example.mvvmcompose.screen.DetailScreen
import com.example.mvvmcompose.ui.theme.MVVMComposeTheme
import com.example.mvvmcompose.util.Constant
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MVVMComposeTheme {
                // A surface container using the 'background' color from the theme
                DetailScreen()
            }
        }
    }
}
