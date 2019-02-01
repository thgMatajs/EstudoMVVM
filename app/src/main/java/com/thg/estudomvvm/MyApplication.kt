package com.thg.estudomvvm

import android.app.Application
import com.thg.estudomvvm.di.KoinModules
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(KoinModules.appModule))
    }
}