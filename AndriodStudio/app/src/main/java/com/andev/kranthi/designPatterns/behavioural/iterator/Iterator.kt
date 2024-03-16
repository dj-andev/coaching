package com.andev.kranthi.designPatterns.behavioural.iterator

interface Iterator {
    fun hasNext(): Boolean
    fun next(): Any?
}