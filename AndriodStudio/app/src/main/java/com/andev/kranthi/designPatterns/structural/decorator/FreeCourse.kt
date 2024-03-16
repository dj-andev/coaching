package com.andev.kranthi.designPatterns.structural.decorator

//2. Concrete base implementation
class FreeCourse : CourseInterface{

    override fun getCourse(): String {
       return "free course"
    }

    override fun getPrice(): Float {
      return 0.0F
    }
}