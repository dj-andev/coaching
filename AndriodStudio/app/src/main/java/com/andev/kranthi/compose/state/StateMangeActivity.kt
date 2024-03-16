package com.andev.kranthi.compose.state

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.andev.kranthi.R

class StateMangeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.wrapContentSize(), color = Color.White) {
//                stateManageCompose()
            }
        }
    }

 /*   @Composable
    fun stateManageCompose() {
//        var counter = 0
//        var counter = remember{ mutableStateOf(0) }
        var counter = rememberSaveable{ mutableStateOf(0) }
//        var counter by remember{mutableStateOf(0) }
//        val (counter, increament) = remember { mutableStateOf(0) }
        val context = LocalContext.current
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Button(modifier = Modifier
                .padding(10.dp)
                .height(40.dp)
                .width(200.dp),
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    Toast.makeText(context, "Button Clicked", Toast.LENGTH_LONG).show()
//                    increament( counter + 1)
                    counter++
                }) {
                Text(text = "${counter.value}",
                    fontSize = 12.sp,
                    color = colorResource(id = R.color.white),
                    modifier = Modifier.alpha(0.5f))
            }
        }
    }*/

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun preview() {
        Surface(modifier = Modifier.wrapContentSize(), color = Color.White) {
//            stateManageCompose()
        }
    }
}


//        var counter = remember{ mutableStateOf(0) }
//        var counter = rememberSaveable{ mutableStateOf(0) }
//        var counter by remember{mutableStateOf(0) }