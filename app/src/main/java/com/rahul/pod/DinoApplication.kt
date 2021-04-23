package com.rahul.pod

import android.app.Application
import com.rahul.pod.categories.di.categoryModule
import com.rahul.pod.dashboard.di.dashboardModule
import com.rahul.pod.di.appModule
import com.rahul.pod.login.di.loginModule
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
            modules(arrayListOf(appModule, loginModule, dashboardModule,categoryModule))
        }
    }
}