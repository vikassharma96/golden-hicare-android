package com.teckudos.goldenhicare

import android.app.Application
import timber.log.Timber

class GoldenHicareApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}