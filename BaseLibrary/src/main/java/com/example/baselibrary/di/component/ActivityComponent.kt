package com.example.baselibrary.di.component

import android.app.Activity
import android.content.Context
import com.example.baselibrary.di.ActivityScope
import com.example.baselibrary.di.module.ActivityModule
import com.example.baselibrary.di.module.AppModule
import com.example.baselibrary.di.module.LifeCycleModule
import com.trello.rxlifecycle.LifecycleProvider
import dagger.Component
import dagger.Module

@ActivityScope
@Component (dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class,LifeCycleModule::class))
interface ActivityComponent {
    fun activty():Activity
    fun context(): Context
    fun lifecycleProvider(): LifecycleProvider<*>
}