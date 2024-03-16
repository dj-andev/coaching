package com.andev.kranthi.designPatterns.structural.decorator

//1. Create an interface which is used for base functionalities and decor class
interface CourseInterface {
    fun getCourse(): String
    fun getPrice(): Float
}