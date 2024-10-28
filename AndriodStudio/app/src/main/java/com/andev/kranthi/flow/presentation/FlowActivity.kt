package com.andev.kranthi.flow.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.andev.kranthi.R
import com.andev.kranthi.flow.data.ApiOutCome
import com.andev.kranthi.flow.data.Repository
import com.andev.kranthi.flow.data.RetrofitClient
import com.andev.kranthi.flow.data.model.SampleData
import com.andev.kranthi.flow.domain.MyUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.util.ArrayList

class FlowActivity : AppCompatActivity() {

    private val viewModel: MyViewmodel by viewModels {
        ViewModelFactory(MyUseCase(Repository(RetrofitClient.apiService)))
    }
    private var isRxCall = false;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)

//            understandClodFlow()
//            understandStateFlow()
//        understandSharedFlow()

        val (recyclerView, resultTxt) = initialiseView()

        viewModel.getPostLiveData().observe(this, Observer { result ->
            when (result) {
                is ApiOutCome.Loading -> {
                    resultTxt.text = "Loading"
                    recyclerView.adapter = ItemAdapter(ArrayList<SampleData>())
                }
                is ApiOutCome.Success -> {
                    resultTxt.text = "Completed"
                    recyclerView.adapter = ItemAdapter((result as ApiOutCome.Success).data)
                }
                is ApiOutCome.Error -> {
                    resultTxt.text = "Error :   ${(result as ApiOutCome.Error).message}"
                    Log.i("CALL...", "Error :   ${(result as ApiOutCome.Error).message}")
                    recyclerView.adapter = ItemAdapter(ArrayList<SampleData>())
                }
            }
        })
    }

    private fun initialiseView(): Pair<RecyclerView, TextView> {
        val toggleButton: ToggleButton = findViewById(R.id.toggleButton)
        val btn_trigger = findViewById<Button>(R.id.btn_trigger)
        val btn_clear = findViewById<Button>(R.id.btn_clear)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val resultTxt = findViewById<TextView>(R.id.txt_result)
        btn_trigger.setOnClickListener {
            if (isRxCall) {
                Log.i("CALL...", "Rx calll....")
                viewModel.getDataByRxCall()
            } else {
                Log.i("CALL...", "Flow calll....")
                viewModel.getDataByFlowCall()
            }
        }

        toggleButton.setOnCheckedChangeListener { _, isChecked ->
            isRxCall = isChecked
        }

        btn_clear.setOnClickListener {
            recyclerView.adapter = ItemAdapter(ArrayList<SampleData>())
            resultTxt.text = ""
        }
        return Pair(recyclerView, resultTxt)
    }


    /**********************************************************************************************************************************************************/

     fun understandClodFlow(){
        lifecycleScope.launch {
            delay(6000)
            viewModel.getFlow().collect { item ->
                run {
                    Log.i("Flow Collector - 1", "$item")
                }
            }
        }
        lifecycleScope.launch {
            delay(6000)
            viewModel.getFlow().collect { item ->
                run {
                    Log.i("Flow Collector - 2", "$item")
                }
            }
        }
    }

     fun understandStateFlow(){ //Hot flow
         lifecycleScope.launch {
//             delay(6000)
             viewModel.getStateFlowFlow().collect { item ->
                 run {
                     Log.i("Stateflow Collector - 1", "$item")

                 }
             }
         }
        /* lifecycleScope.launch {
             delay(5000)
             viewModel.getStateFlowFlow().collect { item ->
                 run {
                     Log.i("Stateflow Collector - 2", "$item")

                 }
             }
         }*/
    }

    fun understandSharedFlow(){ //Hot flow
        lifecycleScope.launch {
            delay(1000)
            viewModel.getSharedFlowFlow().collectLatest { item ->
                run {
                    Log.i("ShareFlow Collector - 1", "$item")

                }
            }
        }

       /* lifecycleScope.launch {
            delay(5000)
            viewModel.getSharedFlowFlow().collectLatest { item ->
                run {
                    Log.i("ShareFlow Collector - 2", "$item")
                }
            }
        }*/

    }
}