package com.andev.kranthi.designPatterns.creational.SingleTone

class SingletoneClass {
    /**
     * 1. Create private constructor
     * 2. Create private static class instance
     * 3. Create static instance method whihc return the class instance
     **/
    private constructor()

    companion object {
        private lateinit var INSTANCE: SingletoneClass

        fun getInstance(): SingletoneClass {
            synchronized(this){
                if (!this::INSTANCE.isInitialized) {
                    synchronized(this){
                        INSTANCE = SingletoneClass()
                    }
                }
            }
            return INSTANCE
        }
    }
}