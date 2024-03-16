package com.andev.kranthi.compose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.andev.kranthi.R
import com.andev.kranthi.data.Person
import com.andev.kranthi.data.getSampleData

class RecyclerActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.wrapContentSize(), color = Color.Yellow) {
                PrepareRecyclerView(persons = getSampleData())
            }
        }
    }
}

@Composable
fun PrepareRecyclerView(persons : List<Person>){
    LazyColumn{
        items(persons){person ->
            PrepareRow(person = person)
        }
    }
}
@Composable
fun PrepareRow(person : Person){
    val context = LocalContext.current
    Card(modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
        .fillMaxWidth().clickable { Toast.makeText(context, "${person.name} Clicked", Toast.LENGTH_SHORT).show() },
        shape = RoundedCornerShape(CornerSize(10.dp)),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Row(modifier = Modifier.padding(5.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "image",
                modifier = Modifier
                    .padding(8.dp)
                    .size(80.dp)
                    .align(Alignment.CenterVertically)
                    .clip(RoundedCornerShape(CornerSize(10.dp)))
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Name : ${person.name}",modifier = Modifier.padding(8.dp))
                Text(text = "Age : ${person.age}",modifier = Modifier.padding(8.dp))
                Text(text = "Mobile : ${person.mobile}",modifier = Modifier.padding(8.dp))
                Text(text = "Occupation : ${person.occupation}",modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun preview() {
    Surface(modifier = Modifier.wrapContentSize(), color = Color.Yellow) {
        PrepareRecyclerView(getSampleData())
    }
}