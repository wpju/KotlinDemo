package com.example.usercenter.ui.di.module

import com.example.baselibrary.di.PerComponentScope
import com.example.usercenter.ui.service.UserService
import com.example.usercenter.ui.service.imp.UserServiceImpl
import dagger.Module
import dagger.Provides

@Module
class UserModule {

    @PerComponentScope
    @Provides
    fun providerUserService(service: UserServiceImpl ):UserService{
        return service
    }
}