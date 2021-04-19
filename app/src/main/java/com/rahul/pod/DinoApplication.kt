package com.rahul.pod

import android.app.Application
import com.rahul.pod.di.navigationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class DinoApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoinModules()
    }

    private fun initKoinModules(){
        startKoin {
            androidLogger()
            androidContext(this@DinoApplication)
            modules(navigationModule)
        }
    }
}