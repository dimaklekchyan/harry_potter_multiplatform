package com.klekchyan.harrypottermultiplatform.android

import android.app.Application
import com.klekchyan.harrypottermultiplatform.PlatformSDK
import com.klekchyan.harrypottermultiplatform.platform.PlatformConfiguration

class HarryPotterApp: Application() {
    override fun onCreate() {
        super.onCreate()

        initPlatformSDK()
    }
}

fun HarryPotterApp.initPlatformSDK() =
    PlatformSDK.init(
        platformConfiguration = PlatformConfiguration(applicationContext)
    )