package com.example.baselibrary.di.module

import android.content.Context
import com.example.baselibrary.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: BaseApplication) {

    @Singleton
    @Provides
    fun providerContext():Context{
        return context
    }
}