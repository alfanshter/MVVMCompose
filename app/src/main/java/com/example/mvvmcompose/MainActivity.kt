package com.example.mvvmcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                App()
            }
        }
    }
}

@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category" ){
        composable(route= "category"){
            CategoryScreen {
                navController.navigate("detail/${it}")
            }
        }
        composable(route = "detail/{category}",
            arguments = listOf(
                navArgument("category"){
                    type = NavType.StringType
                }
            )
        ){
            DetailScreen()
        }
    }
}
/*
@Composable
fun App() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "registration"  ){
        composable(route = "registration"){
            RegistrationScreen{
                navController.navigate("main/{$it}")
            }
        }
        composable(route = "login"){
            LoginScreen()
        }
        composable(route = "main/{email}", arguments = listOf(
            navArgument("email"){
                type = NavType.StringType
            }
        )){
            val email = it.arguments!!.getString("email")
            MainScreen(email!!)
        }
    }
}

@Composable
fun RegistrationScreen(onClick : (email : String) -> Unit) {
        Text(text = "Registration", style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.clickable {
                onClick("alfanno8@gmail.com")
            })
}

@Composable
fun LoginScreen() {
    Text(text = "login", style = MaterialTheme.typography.headlineSmall)
}

@Composable
fun MainScreen(email : String) {
    Text(text = "Main Screen - $email", style = MaterialTheme.typography.headlineSmall)
}*/
