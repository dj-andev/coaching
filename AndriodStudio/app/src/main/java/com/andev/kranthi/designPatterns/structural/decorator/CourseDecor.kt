package com.andev.kranthi.designPatterns.structural.decorator

//3. Create a decor class for the new add-on feature.
//4. Which implements Base interface and keeps the reference of it .
abstract class CourseDecor: CourseInterface {
    private lateinit var courseInterface : CourseInterface
    constructor(courseInterface : CourseInterface){
        this.courseInterface = courseInterface
    }

    override fun getCourse(): String {
        return courseInterface.getCourse()
    }

    override fun getPrice(): Float {
        return courseInterface.getPrice()
    }
}