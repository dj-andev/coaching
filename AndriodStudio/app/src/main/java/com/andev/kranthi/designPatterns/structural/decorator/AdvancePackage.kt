package com.andev.kranthi.designPatterns.structural.decorator

class AdvancePackage(courseInterface : CourseInterface): CourseDecor(courseInterface) {

    override fun getCourse(): String {
        return super.getCourse() + getAdvancePackageCourse()
    }

    override fun getPrice(): Float {
        return super.getPrice() + 150.0F
    }

    private fun getAdvancePackageCourse(): String{
       return "with advance course"
    }
}