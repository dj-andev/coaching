package com.andev.kranthi

import com.andev.kranthi.TestCode.Child
import com.andev.kranthi.TestCode.SomeInterface
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SampleTestCode {

    @Test
    fun validateFun1(){
        val childSpy = Mockito.spy(Child())
        childSpy.SomeSample()
        Mockito.verify(childSpy, Mockito.times(1)).SomeFun1("","")
    }

    @Test
    fun validateFun2(){
        val childSpy = Mockito.spy(Child())
        childSpy.SomeSample2()
        Mockito.verify(childSpy, Mockito.times(1)).SomeFun2("","","")
    }
}