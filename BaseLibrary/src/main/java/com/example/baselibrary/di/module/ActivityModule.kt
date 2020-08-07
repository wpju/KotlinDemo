package com.example.baselibrary.di.module

import android.app.Activity
import com.example.baselibrary.common.BaseApplication
import com.example.baselibrary.di.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: Activity) {

    @ActivityScope
    @Provides
    fun provideractivity():Activity{
        return activity
    }
}