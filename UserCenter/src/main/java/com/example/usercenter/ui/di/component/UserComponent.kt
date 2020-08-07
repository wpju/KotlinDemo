package com.example.usercenter.ui.di.module.component

import com.example.baselibrary.di.PerComponentScope
import com.example.baselibrary.di.component.ActivityComponent
import com.example.usercenter.ui.activity.RegisterActivity
import com.example.usercenter.ui.di.module.UserModule
import dagger.Component

@PerComponentScope
@Component (dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
    fun inject(activity: RegisterActivity)
}