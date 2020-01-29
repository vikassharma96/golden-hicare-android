package com.teckudos.goldenhicare

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import com.teckudos.goldenhicare.utils.SharedPreferenceUtil
import timber.log.Timber

class GoldenHicareApplication : Application() {

    companion object {
        lateinit var instance: GoldenHicareApplication
        fun getContext(): Context {
            return instance.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.plant(Timber.DebugTree())
        Stetho.initializeWithDefaults(this)
        SharedPreferenceUtil.init(this)
    }
}