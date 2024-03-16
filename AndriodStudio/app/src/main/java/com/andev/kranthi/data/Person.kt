package com.andev.kranthi.data

data class Person (val name: String, val age: Int, val mobile: String,val occupation: String)

fun getSampleData(): List<Person>{
    val person = listOf(
        Person("Person-1", 23, "+91-992992992","Employed"),
        Person("Person-2", 43, "+91-992992992","Self-Employed"),
        Person("Person-3", 26, "+91-992992992","Employed"),
        Person("Person-4", 27, "+91-992992992","Employed"),
        Person("Person-5", 22, "+91-992992992","Self-Employed"),
        Person("Person-6", 27, "+91-992992992","Self-Employed"),
        Person("Person-7", 22, "+91-992992992","Self-Employed"),
        Person("Person-8", 28, "+91-992992992","Employed"),
        Person("Person-9", 22, "+91-992992992","Self-Employed"),
        Person("Person-10", 27, "+91-992992992","Employed"),
        Person("Person-11", 28, "+91-992992992","Employed"),
        Person("Person-12", 29, "+91-992992992","Self-Employed"),
        Person("Person-13", 24, "+91-992992992","Employed"),
        Person("Person-14", 22, "+91-992992992","Self-Employed"),
        Person("Person-15", 80, "+91-992992992","Employed"),
        Person("Person-16", 33, "+91-992992992","Self-Employed"),

    )
    return person
}