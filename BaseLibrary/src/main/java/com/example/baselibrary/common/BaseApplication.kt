package com.example.baselibrary.common

import android.app.Application
import com.example.baselibrary.di.component.AppComponent
import com.example.baselibrary.di.component.DaggerAppComponent
import com.example.baselibrary.di.module.AppModule

/*
    Application 基类
 */
open class BaseApplication : Application() {

    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        initAppInjection()
    }

    /*
       Application Component初始化
    */
    private fun initAppInjection() {
        appComponent=DaggerAppComponent.builder().appModule(AppModule(this)).build()

    }

}
