package com.example.baselibrary.di.component

import android.content.Context
import com.example.baselibrary.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context():Context
}