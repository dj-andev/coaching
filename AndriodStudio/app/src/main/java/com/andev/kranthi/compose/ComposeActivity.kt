package com.andev.kranthi.compose

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.AbsoluteCutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andev.kranthi.R
import com.andev.kranthi.ui.theme.KranthiTheme

@ExperimentalMaterial3Api
class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KranthiTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = Color.Red) {
                    Greeting("First composable")
//                    getClickableButton()
//                    prepareToolbarWithBackButton()
//                    prepareToolbarWithMenu()
//                    prepareLoginView()
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Text(text = "Hi $name!", modifier = Modifier
        .wrapContentSize()
        .padding(start = 15.dp, end = 15.dp, bottom = 15.dp, top = 15.dp)
        .alpha(1.0f)
        .clickable {
            Toast.makeText(context, context.getText(R.string.app_name), Toast.LENGTH_LONG).show()
        }, color = Color.Green)
}

@Composable
fun getClickableButton() {
    Box(
        Modifier
            .fillMaxSize()
            .border(width = 4.dp, color = Color.Red, shape = AbsoluteCutCornerShape(20.dp))
            .background(color = Color.Green)
            .wrapContentSize(Alignment.Center)) {
        val context = LocalContext.current;

        Button(modifier = Modifier
            .padding(10.dp)
            .height(40.dp),
            shape = RoundedCornerShape(10.dp),
            onClick = { Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()}) {
            Text(text = stringResource(id = R.string.app_name)/*"Click me"*/,
                fontSize = 12.sp,
                color = colorResource(id = R.color.lemonade_night),
                modifier = Modifier.alpha(0.5f))
        }
    }
}

@Composable
fun prepareListView(){

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun prepareLoginView(){

    val userName = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier
            .size(100.dp)
            .fillMaxWidth())
        Text(
            text = "Hello!...",
            fontSize = 30.sp,
            color = Color.Red
        )
        Text(
            text = "Welcome...",
            fontSize = 30.sp,
            color = Color.Red
        )
        Text(
            text = "Please do login... ",
            fontSize = 30.sp,
            color = Color.Red
        )

        Spacer(modifier = Modifier.size(40.dp))

        OutlinedTextField(
            value = userName.value,
            onValueChange = { userName.value = it },
            leadingIcon = { Icon(Icons.Default.Info, contentDescription ="person" ) },
            label = { Text(text = "User Name")},
            placeholder = { Text(text = "Enter User Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            leadingIcon = { Icon(Icons.Default.Info, contentDescription ="password" ) },
            label = { Text(text = "Password")},
            placeholder = { Text(text = "Enter Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.size(40.dp))
        val context = LocalContext.current
        OutlinedButton(onClick = { validate(userName.value, password.value, context.applicationContext) },shape = RoundedCornerShape(10.dp)) {
            Text(
                text = "Login...",
                fontSize = 20.sp,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .padding(5.dp)
            )
        }
    }
}

private fun validate( userName: String, password: String, context : Context){

    if (userName == "1234" && password == "1234"){
        Toast.makeText(context, "User authenticated", Toast.LENGTH_LONG).show()
        navigateToListScreen(context = context)
    } else {
        Toast.makeText(context, "Authentication failed", Toast.LENGTH_LONG).show()
    }
}

private fun navigateToListScreen(context: Context){
    val intent = Intent(context, RecyclerActivity::class.java)
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
}


@ExperimentalMaterial3Api
@Composable
fun prepareToolbarWithBackButton(){
    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(Color(0xff8d6e63)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                        text = "Content of the page",
                fontSize = 30.sp,
                color = Color.White
                )
                Text(
                    text = "Content of the page",
                    fontSize = 30.sp,
                    color = Color.White
                )
                Text(
                    text = "Content of the page",
                    fontSize = 30.sp,
                    color = Color.White
                )
                Text(
                    text = "Content of the page",
                    fontSize = 30.sp,
                    color = Color.White
                )
            }

        },
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Top App Bar")
                },
                navigationIcon = {
                    IconButton(onClick = { finishActivity() }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                }
            )
        })
}

@ExperimentalMaterial3Api
@Composable
fun prepareToolbarWithMenu(){
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Top App Bar")
                },
                navigationIcon = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Menu clicked...", Toast.LENGTH_LONG).show()
                    }) {
                        Icon(Icons.Filled.Menu, "menu")
                    }
                },
                actions = {
                    IconButton(onClick = {
                        Toast.makeText(context, "Notiiccation Menu clicked...", Toast.LENGTH_LONG).show()
                    }) {
                        Icon(Icons.Filled.Notifications, "noti")
                    }
                    IconButton(onClick = {
                        Toast.makeText(context, "Search clicked...", Toast.LENGTH_LONG).show()
                    }) {
                        Icon(Icons.Filled.Search, "search")
                    }
                    IconButton(onClick = {
                        Toast.makeText(context, "Setting clicked...", Toast.LENGTH_LONG).show()
                    }) {
                        Icon(Icons.Filled.Settings, "sett")
                    }
                    IconButton(onClick = {
                        Toast.makeText(context, "Share Menu clicked...", Toast.LENGTH_LONG).show()
                    }) {
                        Icon(Icons.Filled.Share, "share")
                    }
                }
            )
        }, content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(Color(0xff8d6e63)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Content of the page",
                    fontSize = 30.sp,
                    color = Color.White
                )
            }
            Box(modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .border(width = 4.dp, color = Color.Red, shape = RoundedCornerShape(5.dp))
                    .background(color = Color.Green)
                    .wrapContentSize(Alignment.Center)) {
                val context = LocalContext.current;

                Button(modifier = Modifier
                    .padding(10.dp)
                    .height(40.dp),
                    shape = RoundedCornerShape(10.dp),
                    onClick = { Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()}) {
                    Text(text = stringResource(id = R.string.app_name)/*"Click me"*/,
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.lemonade_night),
                        modifier = Modifier.alpha(0.5f))
                }
            }
        },
        floatingActionButton = {
            val context = LocalContext.current
            FloatingActionButton(
                modifier = Modifier.size(40.dp), // 40 is a mini-fab
                onClick = {
                    Toast.makeText(context, "Floating action clicked...", Toast.LENGTH_LONG).show()
                }
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "floating")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    )
}


private fun finishActivity(){
    finishActivity()
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true, showSystemUi = true, name = "light mode")
@Preview(showBackground = true, showSystemUi = true, name = "dark mode", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun GreetingPreview() {
    Surface(modifier = Modifier.wrapContentSize(), color = Color.Red) {
        Greeting("First composable")
//        getClickableButton()
//          prepareToolbarWithBackButton()
//        prepareToolbarWithMenu()
//        prepareLoginView()
    }
}