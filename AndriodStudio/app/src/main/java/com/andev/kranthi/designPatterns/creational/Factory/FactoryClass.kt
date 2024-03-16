package com.andev.kranthi.designPatterns.creational.Factory

class FactoryClass {

    fun getRingtone(ringtoneType: RingtoneType): Ringtone {
        return when(ringtoneType) {
            RingtoneType.SYSTEM ->  SystemRingtone()
            RingtoneType.CUSTOM ->  CustomRingtone()
            RingtoneType.APP_SPECIFIC ->  AppSpecificRingtone()
        }
    }
}