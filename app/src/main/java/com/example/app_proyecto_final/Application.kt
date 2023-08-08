package com.example.app_proyecto_final

import android.app.Application
import com.example.app_proyecto_final.di.DataModule
import com.example.app_proyecto_final.di.DomainModule
import com.example.app_proyecto_final.di.PresentationModule
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext
import org.koin.core.logger.Level

class Application: Application() {
    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            androidLogger(
                if (BuildConfig.DEBUG) {
                    Level.INFO
                } else {
                    Level.NONE
                }
            )
            androidContext(this@Application)
            modules(
                PresentationModule,
                DomainModule,
                DataModule
            )
        }
    }
}