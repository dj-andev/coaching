package com.andev.kranthi

import android.app.Service
import android.os.Bundle
import android.text.Editable.Factory
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.andev.kranthi.databinding.FragmentFirstBinding
import com.andev.kranthi.designPatterns.behavioural.mediator.ColleagueImp
import com.andev.kranthi.designPatterns.behavioural.mediator.MediatorCompImpl
import com.andev.kranthi.designPatterns.behavioural.observer.ObserverImp
import com.andev.kranthi.designPatterns.behavioural.observer.SubjectImp
import com.andev.kranthi.designPatterns.behavioural.state.EngineStartState
import com.andev.kranthi.designPatterns.behavioural.state.EngineStopState
import com.andev.kranthi.designPatterns.behavioural.state.StateContext
import com.andev.kranthi.designPatterns.behavioural.statergy.CreditCardPayment
import com.andev.kranthi.designPatterns.behavioural.statergy.DairyFood
import com.andev.kranthi.designPatterns.behavioural.statergy.Item
import com.andev.kranthi.designPatterns.behavioural.statergy.ShoppingCart
import com.andev.kranthi.designPatterns.behavioural.statergy.Snacks
import com.andev.kranthi.designPatterns.behavioural.statergy.Vegitables
import com.andev.kranthi.designPatterns.creational.Factory.FactoryClass
import com.andev.kranthi.designPatterns.creational.Factory.Ringtone
import com.andev.kranthi.designPatterns.creational.Factory.RingtoneType
import com.andev.kranthi.designPatterns.creational.SingleTone.SingletoneClass
import com.andev.kranthi.designPatterns.creational.abstractFactory.VehicleFactory
import com.andev.kranthi.designPatterns.creational.abstractFactory.vehicleFactories.BusFactory
import com.andev.kranthi.designPatterns.creational.abstractFactory.vehicleFactories.TruckFactory
import com.andev.kranthi.designPatterns.creational.abstractFactory.vehicleFactories.VanFactory
import com.andev.kranthi.designPatterns.creational.builder.Vehicle
import com.andev.kranthi.designPatterns.structural.adapter.StockDataProvideClient
import com.andev.kranthi.designPatterns.structural.bridge.Partners
import com.andev.kranthi.designPatterns.structural.bridge.PrimePartner
import com.andev.kranthi.designPatterns.structural.bridge.Resolution1040Px
import com.andev.kranthi.designPatterns.structural.bridge.Resolution480Px
import com.andev.kranthi.designPatterns.structural.bridge.Resolution8KPx
import com.andev.kranthi.designPatterns.structural.bridge.YoutubePartener
import com.andev.kranthi.designPatterns.structural.composite.Boxes
import com.andev.kranthi.designPatterns.structural.composite.ProductItem
import com.andev.kranthi.designPatterns.structural.decorator.AdvancePackage
import com.andev.kranthi.designPatterns.structural.decorator.CourseDecor
import com.andev.kranthi.designPatterns.structural.decorator.CourseInterface
import com.andev.kranthi.designPatterns.structural.decorator.FreeCourse
import com.andev.kranthi.designPatterns.structural.decorator.MasterWithRealTimeProjectPackage
import com.andev.kranthi.designPatterns.structural.facade.CustomerCareOperatorFacade
import com.andev.kranthi.designPatterns.structural.proxy.CashPayment
import com.andev.kranthi.designPatterns.structural.proxy.DebitCardPayment
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    companion object{
        const val TAG = "Coroutine-Test"
    }

    private var _binding: FragmentFirstBinding? = null
    private var fristFragmentViewModel : FristFragmentViewModel?= null;

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        fristFragmentViewModel = ViewModelProvider(this).get(FristFragmentViewModel::class.java)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//            CoroutineScope(Dispatchers.IO).launch {
//                taskOne()
//            }
//            CoroutineScope(Dispatchers.IO).launch {
//                taskTwo()
//            }



                CoroutineScope(Dispatchers.IO).launch {
                    val time = measureTimeMillis {
                        val job1 = CoroutineScope(Dispatchers.IO).launch {
                            Log.i(
                                TAG,
                                " Fetch first user info task started- ${Thread.currentThread().name}"
                            )
                            task()
                        }

                        job1.join()

                        val job2 = CoroutineScope(Dispatchers.IO).launch {
                            Log.i(
                                TAG,
                                " Fetch second user info task started- ${Thread.currentThread().name}"
                            )
                            task()
                        }


                    job2.join()

//                        Log.i(TAG, " job1 - ${job1.await()}, job2 - ${job2.await()}")
                    }
                    Log.i(TAG, " time - $time")
                }





//            fristFragmentViewModel?.executeTask();
        }
    }

    suspend fun taskOne(){
        Log.i(TAG, "Start task 1........"+Thread.currentThread())
        delay(1000)
        Log.i(TAG, "End task 1......."+Thread.currentThread())
    }

     suspend fun taskTwo(){
        Log.i(TAG, "Start task 2........"+Thread.currentThread())
        delay(1000)
        Log.i(TAG, "End task  2......."+Thread.currentThread())
    }

    suspend fun task() : String{
        Log.i(TAG, "Fetch userInfo.... - ${Thread.currentThread().name}")
        delay(1000L)
        withContext(Dispatchers.Main){
            Log.i(TAG, "Updating UI.... - ${Thread.currentThread().name}")
            Log.i(TAG, " UI updated - ${Thread.currentThread().name}")
        }
        Log.i(TAG, " Fetch user task completed- ${Thread.currentThread().name}")
        return "value retruned"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getDummyObservable(): Observable<String>{
        return Observable.just<String>("Some content")
    }

    override fun onStart() {
        super.onStart()
        // SingleTone
        /*   SingletoneClass.getInstance()

     // Factory

        val ringtone = FactoryClass().getRingtone(RingtoneType.SYSTEM)
        ringtone.playRingtone()
        ringtone.stopRingtone()

        // Abstract factory

        val bus = VehicleFactory.getVehicle(BusFactory("BS6", true, 20, "RED"))
        val van = VehicleFactory.getVehicle(VanFactory("BS5", true, 20, "RED"))
        val truck = VehicleFactory.getVehicle(TruckFactory("BS6", true, 20, "RED"))

        val vehicle1 = Vehicle.Companion.VehicleBuilder("BS5", true).build()
        val vehicle2 = Vehicle.Companion.VehicleBuilder("BS5", true).setColor("red").setFuelCapacity(90).build()

        //State
        val stateContext = StateContext()

        stateContext.setState(EngineStartState())
        stateContext.performAction()

        stateContext.setState(EngineStopState())
        stateContext.performAction()

        if (stateContext.getState() is EngineStopState){

        }
        if (stateContext.getState() is EngineStartState){

        }

        // Observer

        val subjectImp = SubjectImp()

        val observerImp1 = ObserverImp().setSubject(subjectImp)
        val observerImp2 = ObserverImp().setSubject(subjectImp)
        val observerImp3 = ObserverImp().setSubject(subjectImp)
        val observerImp4 = ObserverImp().setSubject(subjectImp)
        val observerImp5 = ObserverImp().setSubject(subjectImp)

        subjectImp.register(observerImp1)
            .register(observerImp2)
            .register(observerImp3)
            .register(observerImp4)
            .register(observerImp5)

        subjectImp.setInformation("New info.......")

        // Mediator
        // Create mediator object
        // add all colleague to mediator

        val mediatorCompImpl = MediatorCompImpl()

        val colleagueOne = ColleagueImp(mediatorCompImpl, "colleagueOne")
        val colleagueTwo = ColleagueImp(mediatorCompImpl, "colleagueTwo")
        val colleagueThree = ColleagueImp(mediatorCompImpl, "colleagueThree")
        val colleagueFour = ColleagueImp(mediatorCompImpl, "colleagueFour")

        mediatorCompImpl.addColleague(colleagueOne).addColleague(colleagueTwo).addColleague(colleagueThree).addColleague(colleagueFour)

        colleagueOne.pushMessage("Some Info....")

        // Statergy
        val shoppingCart = ShoppingCart()
        val dairyFood = DairyFood("31dqedqwedda", 20.0f, 4)
        val snacks = Snacks("3123dxasdasdxa", 50.0f, 10)
        val vegistables = Vegitables("5234dsad", 70.0f, 4)

        shoppingCart.addItem(dairyFood)
        shoppingCart.addItem(snacks)
        shoppingCart.addItem(vegistables)

        shoppingCart.pay(CreditCardPayment("VISA", 1234))

//        Adapter

        val stockDataProvideClient = StockDataProvideClient()
        stockDataProvideClient.getStockInfo()

        // Facade
        val customerCareOperatorFacade = CustomerCareOperatorFacade()
        customerCareOperatorFacade.itemDetails()

        //Decorator
        //1. Create an interface which is used for base functionalities and decor class
        //2. Concrete base implementation exp (Free course)
        //3. Create a decor class for the new add-on feature.
        //4. Which implements Base interface and keeps the reference of it
        //5. Add-On class extends the decor class
        val freeCourse: CourseInterface = FreeCourse()
        val advanceCourse: CourseInterface = AdvancePackage(freeCourse)
        val masterPackage: CourseInterface = MasterWithRealTimeProjectPackage(advanceCourse)

        //Bridge
        val prime1040: Partners = PrimePartner(Resolution1040Px())
        prime1040.playVideo("abc.mp4")

        val prime480: Partners = PrimePartner(Resolution480Px())
        prime480.playVideo("abc.mp4")

        val prime8K: Partners = PrimePartner(Resolution8KPx())
        prime8K.playVideo("abc.mp4")


        // Composite
        val item1 = ProductItem(120f, "toy")
        val item2 = ProductItem(100f, "gym")
        val item3 = ProductItem(120f, "books")

        val box1 = Boxes()
        box1.addProduct(item1)
        box1.addProduct(item2)

        val box2 = Boxes()
        box2.addProduct(item3)


        val box3 = Boxes()
        box3.addProduct(item3)
        box3.addProduct(item3)
        box3.addProduct(item3)
        box3.addProduct(box1)

        val mainBox = Boxes()
        mainBox.addProduct(item1)
        mainBox.addProduct(box1)
        mainBox.addProduct(box2)
        mainBox.addProduct(box3)

        val boxPrice =  mainBox.getPrice()*/
        compositePattern()
    }

    fun compositePattern(){
        val item1 = ProductItem(50f, "toy")
        val item2 = ProductItem(100f, "gym")
        val item3 = ProductItem(150f, "books")

        // 150
        val box1 = Boxes()
        box1.addProduct(item1)
        box1.addProduct(item2)

        //150
        val box2 = Boxes()
        box2.addProduct(item3)

        // 600
        val box3 = Boxes()
        box3.addProduct(item3)
        box3.addProduct(item3)
        box3.addProduct(item3)
        box3.addProduct(box1)

        //950
        val mainBox = Boxes()
        mainBox.addProduct(item1)
        mainBox.addProduct(box1)
        mainBox.addProduct(box2)
        mainBox.addProduct(box3)

        val boxPrice =  mainBox.getPrice()

        Log.i("Composite", "Box price :  $boxPrice")


        //Proxy
        // 1. Create an interface with required operation.
        // 2. Both real and proxy class implemnt that interface.
        // 3. Real Object hold the operation logic.
        // 4. Proxy object will hold the original object reference.
        // 5. If Proxy object satisfies then allows to access the real object to perform operations.
        val debitCardPayment = DebitCardPayment(CashPayment())
        debitCardPayment.addCredentials("1234","abc")
        debitCardPayment.processPayment()
    }
}