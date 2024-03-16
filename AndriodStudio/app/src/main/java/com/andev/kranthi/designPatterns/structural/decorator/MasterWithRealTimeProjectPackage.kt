package com.andev.kranthi.designPatterns.structural.decorator

class MasterWithRealTimeProjectPackage (courseInterface : CourseInterface): CourseDecor(courseInterface) {

    override fun getCourse(): String {
        return super.getCourse() + getMasterPackageCourse()
    }

    override fun getPrice(): Float {
        return super.getPrice() + 250.0F
    }

    private fun getMasterPackageCourse(): String{
        return "with master course"
    }
}
